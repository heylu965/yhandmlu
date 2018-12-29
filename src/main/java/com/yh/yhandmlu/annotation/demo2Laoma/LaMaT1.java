package com.yh.yhandmlu.annotation.demo2Laoma;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class LaMaT1 {

    public static void main(String[]arg){
        try {
            List<String> obj = Arrays.asList("laoma","biancheng");
            Class<? extends List> aClass = obj.getClass();

            for (Field f : aClass.getDeclaredFields()){
                f.setAccessible(true);
                System.out.println(f.getName()+"-"+f.get(obj));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
