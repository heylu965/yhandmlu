package com.yh.yhandmlu.泛型;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        List<String> str = new ArrayList();

//        str.add(1);

        Class aClass = str.getClass();
        Class aClass1 = new ArrayList<Integer>().getClass();
        System.out.println(aClass == aClass1); // true
    }
}
