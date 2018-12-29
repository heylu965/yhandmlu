package com.yh.yhandmlu.importCsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {

//    private static String url = "/Users/yanghai/Downloads/cs.csv";
    private static String url = "/Users/yanghai/Downloads/test.csv";

    public static void main(String[] arg){

        File csv = new File(url);


        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        String everyLine = "";
        List<String> allLine = new ArrayList<>();

        try {
            while ((line = bufferedReader.readLine()) != null){
                everyLine = line;
                System.out.println(everyLine);
                allLine.add(everyLine);
            }
            System.out.println("csv表格中所有行数："+allLine.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
