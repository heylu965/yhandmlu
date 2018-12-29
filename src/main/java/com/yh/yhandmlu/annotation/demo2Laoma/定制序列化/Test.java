package com.yh.yhandmlu.annotation.demo2Laoma.定制序列化;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

    public static void main(String[] arg){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Student student = new Student("zhangsan",sdf.parse("1990-12-12"),100d);

            System.out.println(SimpleFormatter.format(student));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
