package com.yh.yhandmlu.importCsv;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class TestClass {


    /**
     * 处理不可见字符
     * https://www.cnblogs.com/zzllx/p/6986794.html
     * https://en.wikipedia.org/wiki/Zero-width_non-joiner
     */
    @Test
    public void test1(){
        String m1 = "fa‌​c5‌​04‌​6b‌​c1‌​0a‌​ca‌​2e‌​1e‌​a9‌​55‌​eb‌​e4‌​53‌​7d‌​c0";
        String m2 = "fac5046bc10aca2e1ea955ebe4537dc0";
        System.out.println("m1的长度:"+m1.length() + "\n" +"m2的长度:" + m2.length());

        byte[] bs = m1.getBytes();
        System.out.print("m1:");
//        for (byte b : bs) {
//           System.out.print(b + " ");
//        }
        System.out.println();
        String all = m1.replaceAll("\\p{C}", "");
        System.out.println(all.length());
        System.out.println(m2.equals(all));
    }

    @Test
    public void test2(){

        BigDecimal bd = new BigDecimal("2");
        BigDecimal bd1 = new BigDecimal("120.01");

        BigDecimal r = bd.divide(bd1,4,BigDecimal.ROUND_HALF_UP);
        System.out.println(r);
        System.out.println(r.multiply(new BigDecimal(100)).doubleValue());
        System.out.println(r.multiply(new BigDecimal(100)).doubleValue());


        Long s = null;
        BigDecimal b = new BigDecimal(s);
        System.out.println(b);

    }

    public static void main(String[] arg){

//        String s1 = "yes";
//        String r = testStr(s1);

        System.out.println(t());

    }

    public static String t(){
        try {
            if (true){
                return "re";
            }
            return "bacl";
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "finally";
        }
    }

    public static String testStr(String str){

        new Thread(){
            public void run(){
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(30000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        if (str.startsWith("y")){
            return "ok";
        }else {
            return "no";
        }

    }

    @Test
    public void test3(){
        String s = "/Users/yanghai/Downloads/test.csv";
        System.out.println(s.substring(s.lastIndexOf("."),s.length()));
    }
    @Test
    public void test4(){
        String str = "";
        String str1 = "11";
        String str2 = "122.134";
        String str3 = "122.00";
        String str4 = "122.001";
        String str5 = "s22.001";
        List<String> strs = new ArrayList();
        strs.add(str);
        strs.add(str1);
        strs.add(str2);
        strs.add(str3);
        strs.add(str4);
        strs.add(str5);
        //金额验证
        Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        for (String s : strs){

            System.out.println("str:"+s+", result:"+pattern.matcher(s).matches());
        }
    }


    @Test
    public void test5(){
        String sku = "[{\"k\":\"颜色\",\"k_id\":1,\"v\":\"蓝色\",\"v_id\":3},{\"k\":\"样式\",\"k_id\":7,\"v\":\"0\",\"v_id\":1260},{\"k\":\"场地\",\"k_id\":159,\"v\":\"时间\",\"v_id\":23}]";

        List<SkuDemo> demos = JSON.parseArray(null,SkuDemo.class);
        System.out.println(demos);

        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (SkuDemo demo : demos){
            if (i == demos.size()){
                sb.append(demo.getV());
            }else {
                sb.append(demo.getV()).append("|");
            }
            i++;
        }
        System.out.println(sb.toString());

    }

    @Test
    public void test6(){
        String pattern = "test_key:{0}_{1}";
        Long s = 1L;
        Long s1 = 2L;
        System.out.println(MessageFormat.format(pattern,s,s1));
    }

    @Test
    public void test7(){
        System.out.println(String.format("请求参数非法 %s", "skuId"));
    }

    @Test
    public void test8(){
        String csvUrl = "http://file-test.yzcdn.cn/upload_files/yz-test-file/2018/09/06/FpnaxsgZBTmWBgPCmigSubkJoC6g.csv";

        String fileName = csvUrl.substring(csvUrl.lastIndexOf("/")+1,csvUrl.length());
        System.out.println(fileName);

    }

    @Test
    public void test9(){

        Integer a = 3;
        if(!(Objects.equals(1,a) || Objects.equals(2,a))){
            System.out.println(a);
        }
        System.out.println("=====");


    }

    @Test
    public void test10(){


        int total = 21;
        int length = 10;
        int seq = total % length == 0 ? total / length : total / length + 1;
        List<Long> subList = null;
        /*for (int a = 0;a < seq;a++){


            if (total < length || (a + 1) * length > total){
                subList = needUpdateItemIds.subList(a * length,total);
            }else {
                subList = needUpdateItemIds.subList(a * length, (a + 1) * length);
            }


        }*/
        System.out.println(seq);

    }


}

@Data
class SkuDemo{
    /*private String k;
    private String k_id;
    private String v;
    private String v_id;*/

    /**
     * 规格项id
     */
    @JSONField(name = "k_id")
    private long kId;

    /**
     * 规格项名称
     */
    private String k;

    /**
     * 值id
     */
    @JSONField(name = "v_id")
    private long vId;

    /**
     * 值 描述
     */
    private String v;
}
