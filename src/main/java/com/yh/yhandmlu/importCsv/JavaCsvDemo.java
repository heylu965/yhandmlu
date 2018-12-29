package com.yh.yhandmlu.importCsv;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class JavaCsvDemo {

    private static String url = "/Users/yanghai/Downloads/test.csv";
    public static void readCsv(){
        try {

            CsvReader reader = new CsvReader(url, ',', Charset.forName("UTF-8"));

            reader.readHeaders();

            String[] header = reader.getHeaders();
            boolean b = checkCsvHeader(header);
//            boolean b = checkVsvHeaderV2(header);
            if (!b){
                System.out.println("Csv 文件非法");
                return;
            }
            for (String s : header){
//                System.out.println(s);
            }

            List<String> contents = new ArrayList<>();
            while (reader.readRecord()){
                contents.add(reader.getRawRecord());
//                System.out.print(reader.getRawRecord()+" ;length:");
//                System.out.println(reader.getRawRecord().split(",").length);

            }

//            System.out.println("===============");
//            System.out.println("Content Size:"+contents.size());

            int line = 1;
            List<DataDemo> c = new ArrayList<>();
            for (String str : contents){
                System.out.println("第"+line+"行：");
                DataDemo dataDemo = new DataDemo();
                // 用英文逗号分割有个问题就是，如果某一列中是包含因为逗号，这种就会出问题；
//                String[] arr =  str.split(",");
                // 使用正则来分割字符，只对引号外面的逗号进行分割，对引号内的不分割。
                String[] arr = str.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                StringBuilder sb = new StringBuilder();
                for (int i = 0;i<arr.length;i++){
                    buildData(i+1,arr[i],dataDemo);
                    if (StringUtils.isEmpty(arr[i])){
                        sb.append("&");
//                        System.out.println("&");
                    }else {
                        sb.append(arr[i]);
//                        System.out.println(arr[i]);
                    }
                    sb.append(",");
                }
                System.out.println(sb.toString());
                line++;
                c.add(dataDemo);
            }
            System.out.println("===============");
            System.out.println("Content Size:"+c.size());
            System.out.println(c);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void buildData(int index,String arr,DataDemo dataDemo){
        switch (index){
            case 1 :
                dataDemo.setItemId(arr);
                break;
            case 2 :
                dataDemo.setSkuId(arr);
                break;
            case 3 :
                dataDemo.setTitle(arr);
                break;
            case 4 :
                dataDemo.setSku(arr);
                break;
            case 5 :
                dataDemo.setPrice(arr);
                break;
        }
    }

    private static boolean checkCsvHeader(String[] headers){
        List<String> headList = new ArrayList<>();
        for(int i = 0 ; i < headers.length;i++){
            headList.add(headers[i]);
        }
        int i = 0;
        for (String s : headList){
            boolean checkResult = checkVsvHeader(i+1,s);
            i++;
            if (!checkResult){
                System.out.println("csv标题校验失败！！！");
                return checkResult;
            }
        }
        return true;
    }

    public static void writeCsv(){
        String url = "/Users/yanghai/Downloads/test-write.csv";

        CsvWriter csvWriter = new CsvWriter(url,',',Charset.forName("UTF-8"));

        String[] headers = {"编号","姓名","年龄"};
        String[] content = {"12365","张山","34"};
        try {
            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            csvWriter.close();
        }
    }

    public static void main(String[] arg){
          readCsv();
//        writeCsv();
    }



    private static boolean checkVsvHeader(int index,String column){
        if (StringUtils.isEmpty(column)){
            return false;
        }
        int length = column.length();
        StringBuilder sb = new StringBuilder();
        for (int a = 0;a < length;a++){
            if (a+1 > length){
                break;
            }
            String subStr = column.substring(a,a+1).trim();
            if (StringUtils.isNotEmpty(subStr)
                    && !Objects.equals("",subStr)
                    && !Objects.equals("(",subStr)
                    && !Objects.equals("（",subStr)
                    && !Objects.equals(")",subStr)
                    && !Objects.equals("）",subStr)
                    && !Objects.equals(",",subStr)
                    && !Objects.equals("，",subStr)){
                sb.append(subStr);
            }
        }
        String bStr = sb.toString();

        System.out.println("bStr length:"+bStr.length());

        bStr = bStr.replaceAll("\\p{C}", "");
        System.out.println("bStr length:"+bStr.length());

        Map<Integer,String> headerMap = headerMap();
        String value = headerMap.get(index);

        System.out.println("value length:"+value.length());

        System.out.println(value.hashCode());
        System.out.println(bStr.hashCode());

        if (StringUtils.isEmpty(value)){
            return false;
        }
        if (value.equals(bStr)){
            return true;
        }
        if (!value.equalsIgnoreCase(bStr)){
            return false;
        }
        return true;
    }

    /**
     * 校验csv文件标题是否合法
     * @param column
     * @return
     */
    private static boolean checkVsvHeaderV2(String[] column){
        if (column.length == 0){
            return false;
        }
        LinkedList<String> list = new LinkedList<>();
        int length = column.length;
        for (int a = 0 ; a < length ; a++){
            String col = column[a];
            if (col.length() == 0){
                return false;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < col.length();i++){
                int start = 0;
                int end = 0;
                if (a == 0){
                    if (i + 2 > col.length()){
                        break;
                    }
                    start = i+1;
                    end = i+2;
                }else {
                    if (i + 1 > col.length()){
                        break;
                    }
                    start = i;
                    end = i+1;
                }
                String subStr = col.substring(start,end);
                if (StringUtils.isNotEmpty(subStr)
                        && !" ".equals(subStr)
                        && !Objects.equals("(",subStr)
                        && !Objects.equals("（",subStr)
                        && !Objects.equals(")",subStr)
                        && !Objects.equals("）",subStr)
                        && !Objects.equals(",",subStr)
                        && !Objects.equals("，",subStr)){
//                    System.out.println(subStr);
                    sb.append(subStr);
                }
            }
            list.add(sb.toString());
        }

        System.out.println(list);

        for (int i = 1;i<=list.size();i++){
            String v = headerMap().get(i);
            boolean f = v.equals(list.get(i-1).trim());
            if (!f){
                System.out.println(f);
                return f;
            }
        }
        return true;
    }

    private static Map<Integer,String> headerMap(){
        Map<Integer,String> headerMap = new HashMap<>(5);
        headerMap.put(1,"商品ID必填");
        headerMap.put(2,"规格ID");
        headerMap.put(3,"商品名称");
        headerMap.put(4,"规格");
        headerMap.put(5,"调整后价格元必填");
        return headerMap;
    }

    @Data
    static class DataDemo{
        private String itemId;
        private String skuId;
        private String title;
        private String sku;
        private String price;
    }

    /**==========================================================================================*/
    @Test
    public void testTrim(){
        String a = " a";
        String b = "b ";
        String c = " c ";
        String d = " d d ";

        System.out.println("before:"+a+",after:"+a.trim()+"!");
        System.out.println("before:"+b+",after:"+b.trim()+"!");
        System.out.println("before:"+c+",after:"+c.trim()+"!");
        System.out.println("before:"+d+",after:"+d.trim()+"!");
    }

    @Test
    public void processHeaderTest(){
        String title = "商 品 ID( （（必填）";
        System.out.println(title);

        int length = title.length();
        System.out.println(length);


        System.out.println(checkVsvHeader(1,title));
    }

    @Test
    public void testLower(){
        String t1 = "商品ID";
        String t2 = "商品Id";

        boolean flag = t1.equalsIgnoreCase(t2);
        System.out.println(flag);
        boolean flag1 = t1.equals(t2);
        System.out.println(flag1);
    }

    @Test
    public void test(){
        String v = "商品ID必填";
        String v1 = "商品ID必填";
        String v2 = headerMap().get(1);
//        System.out.println(v.equals(v1));
//        System.out.println(v.equals(v2));
//        System.out.println(v1.equals(v2));

        String v3 = new String("商品ID必填");
        String v4 = new StringBuilder("商品ID必填").toString();
        System.out.println(v3.equals(v1));
        System.out.println(v3.equals(v4));
    }

    @Test
    public void test1(){
        LinkedList<String> list = new LinkedList<>();
        list.add("商品ID必填");
        list.add("规格ID");
        list.add("商品名称");
        list.add("规格");
        list.add("调整后价格元必填");

        for (int i = 1;i<=list.size();i++){
            String v = headerMap().get(i);
            System.out.println(v.equals(list.get(i-1)));
        }
    }
}
