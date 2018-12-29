package com.yh.yhandmlu.daily.thread.countdownlatch;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass1 {

    public static void main(String[] arg){
        System.out.println("main Thread start....");
        ExecutorService pool = Executors.newFixedThreadPool(15);


        List<Demo> demoList = new ArrayList<>();

        for (int i=1;i<=10;i++){

            Demo demo = new Demo();
            demo.setIndex(i);
            demoList.add(demo);
        }
        for (int i=1;i<=demoList.size();i++){

            Demo demo = demoList.get(i-1);

            pool.submit(new TestFixedThreadPool(demo,i));
        }


        System.out.println("thread excute end !!!");
        System.out.println(demoList);




        // 5   10302310 ns
        // 10  10118751 ns
        // 15  13878146 ns  11524701 ns
        // 100 44739994 ns
//        System.out.println(System.nanoTime()-start+" ns");

        pool.shutdown();

        System.out.println("main Thread end....");

    }

    @Test
    public void test1(){
        String line = "";
        String PARSE_CSV_REGEX = ",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
        String[] arr = line.split(PARSE_CSV_REGEX);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (StringUtils.isEmpty(arr[i])) {
                sb.append("&");
            } else {
                sb.append(arr[i]);
            }
            sb.append(",");
        }
        System.out.println("each line contents:" + sb.toString());
    }
}

@Data
class Demo{
    private int index;
    private int a;
}


