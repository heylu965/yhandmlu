package com.yh.yhandmlu.设计模式.结构型.adapter;

public class Test {


    public static void main(String[] args) {

        // 对类适配
//        Targetable targetable = new Adapter();
//        targetable.method1();
//        targetable.method2();


        // 对对象适配
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }
}
