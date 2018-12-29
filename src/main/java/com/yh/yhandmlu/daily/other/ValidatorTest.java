package com.yh.yhandmlu.daily.other;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ValidatorTest {


    public static void main(String[] arg) {

        long s = System.currentTimeMillis();
        System.out.println(s());
        System.out.println(System.currentTimeMillis() - s);

    }

    private static String s() {

        System.out.println("start...");

        new Thread() {
            @Override
            public void run() {
                t();
            }
        }.start();

        return "test code";
    }

    private static void t() {
        try {
            System.out.println("start sleep....");
            Thread.sleep(3000);
            System.out.println("end sleep....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_IsNumber() {
        List<String> nums = new ArrayList<>();
        nums.add("123");
        nums.add("123333444456778");
        nums.add("-123");
        nums.add("-123000w3eqwrw");
        nums.add("-123.1");
        nums.add("+123.01");
        nums.add("12.3");
        nums.add(" 12.3 ");
        nums.add("12.3");
        nums.add("12343 ");
        nums.add("  12343 ");
        nums.add("1q212.3");
        nums.add("");
        nums.add("+12.34");

        for (String str : nums) {
            System.out.println("IsNumber---待校验内容：" + str + ",校验结果：" + IsNumber(str.trim()));
            System.out.println("checkAmount---待校验内容：" + str + ",校验结果：" + checkAmount(str.trim()));
        }
    }

    /**
     * 是否数字校验
     *
     * @param number
     * @return
     */
    public static boolean IsNumber(String number) {
        if (StringUtils.isEmpty(number)) {
            return false;
        }
        number = number.trim();
        final String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(number).matches();
    }

    @Test
    public void testTime() {

        Double r = 0D;
        Long diffPrice = 300L;
        Long before = 1300L;
        if (diffPrice == null || diffPrice <= 0L || before == null || before <= 0L) {
            r = 0D;
        }
        BigDecimal bd = new BigDecimal(diffPrice);
        r = bd.divide(new BigDecimal(before), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue();
        System.out.println(r);

        Long diffPrice1 = processDiffPrice(1300L, 1900L);
        System.out.println(diffPrice1);

        System.out.println(processChangeRatio(diffPrice1, 1900L));


    }

    private Long processDiffPrice(Long after, Long before) {
        if (after == null || before == null) {
            return 0L;
        }
        BigDecimal bd = new BigDecimal(after);
        return bd.subtract(new BigDecimal(before)).longValue();
    }

    private Double processChangeRatio(Long diffPrice, Long before) {
        if (diffPrice == null || diffPrice == 0L || before == null || before == 0L) {
            return 0D;
        }
        BigDecimal bd = new BigDecimal(diffPrice);
        return bd.divide(new BigDecimal(before), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue();
    }

    @Test
    public void test1() {
        Double d = null;

        Double o = d / 100;

        System.out.println(o);


    }

    @Test
    public void queryBeforeSixMonthDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();

        System.out.println(sdf.format(date));

        c.add(Calendar.MONTH, -6);

        System.out.println(sdf.format(c.getTime()));

    }


    @Test
    public void beforeOneHour() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - 2);

        System.out.println(sdf.format(c.getTime()));
        System.out.println(c.getTimeInMillis());
        System.out.println(new Date().getTime() - 3600 * 1000);

        System.out.println(sdf.format(new Date()));
        System.out.println(new Date().getTime());

        System.out.println(new Date(c.getTimeInMillis()));


    }

    @Test
    public void testUUID() {
        String uuid = UUID.randomUUID().toString().substring(0, 6) + "-";
        System.out.println(uuid);

        String csvUrl = "http://file-test.yzcdn.cn/upload_files/yz-test-file/2018/09/25/FiYvDbHw2vQRDm-fPcFE3lM20gOW.csv";
        String fileName = csvUrl.substring(csvUrl.lastIndexOf("/"), csvUrl.length());
        String fileName1 = csvUrl.substring(csvUrl.lastIndexOf("/") + 1, csvUrl.length());
        System.out.println(fileName);
        System.out.println(fileName1);
        csvUrl = "files/" + uuid + fileName;
        csvUrl = "files/" + uuid + fileName1;

        System.out.println(csvUrl);

    }


    @Test
    public void testForeach() {
        for (int a = 0; a < 10; a++) {

            for (int b = 0; b < 10; b++) {
                System.out.println("bbbbbbb:" + b);
                if (b == 4) {
                    break;
                }
            }
            System.out.println("aaaaaaa" + a);
        }

        /*BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //添加时间范围过滤
        boolQueryBuilder.must(QueryBuilders
                .rangeQuery("@timestamp")
                .format("yyyy-MM-dd HH:mm:ss")
                .gte(conditionMap.get("createTimeB"))
                .lte(conditionMap.get("createTimeE"))
        );
        AggregationBuilder aggregationBuilder = AggregationBuilders
                .terms(查询字段别名)
                .field(分组字段)
                .order(Terms
                        .Order
                        .aggregation(ES_COUNT_ALIAS, false))
                .size(10)
                .subAggregation(AggregationBuilders
                        .count(统计字段别名)
                        .field(统计的字段)
                );
        SearchRequestBuilder searchRequestBuilder = ElasticsearchHelper
                .getInstance()
                .getClient()
                .prepareSearch(ES_INDEX)
                .setTypes(ES_TYPE)
                .setQuery(boolQueryBuilder)
                .addAggregation(aggregationBuilder)
                .setSize(0);

        SearchResponse sr = searchRequestBuilder.execute().actionGet();
        Terms genders = sr.getAggregations().get(统计字段别名);
        for (Terms.Bucket entry : genders.getBuckets()) {
            list.add((String) entry.getKey() + "-(" + entry.getDocCount() + ")");
        }*/

    }

    @Test
    public void testDouble(){
        Double d = 90.16D * 100;
        BigDecimal db = new BigDecimal(d);
        System.out.println(db.divide(new BigDecimal(100),2, RoundingMode.HALF_UP));
        System.out.println(d/100);
    }

    @Test
    public void testBig()
    {
        Double d = 30001D;
        Double d1 = 1022D;
        Long changeRatio = new BigDecimal(d).divide(new BigDecimal(100),2, RoundingMode.HALF_EVEN).longValue();
        Long changeRatio1 = new BigDecimal(d1).divide(new BigDecimal(100),2, RoundingMode.HALF_EVEN).longValue();
        System.out.println(changeRatio);
        System.out.println(changeRatio1);
        System.out.println(d/100);
    }

    public boolean checkAmount(String amount){
        if (StringUtils.isEmpty(amount)){
            return false;
        }
        Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        return pattern.matcher(amount).matches();
    }

    @Test
    public void testNum(){

        String num = "999999999999999999999999999999999999999999999";
        System.out.println(checkAmount(num));
    }

}
