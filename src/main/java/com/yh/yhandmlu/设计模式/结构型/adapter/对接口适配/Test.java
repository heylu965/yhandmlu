package com.yh.yhandmlu.设计模式.结构型.adapter.对接口适配;

public class Test {

    public static void main(String[] args) {
        Sourceable sourceable = new Source1();
        sourceable.method1();
        sourceable.method2();

        System.out.println("==========");

        Sourceable sourceable1 = new Source2();
        sourceable1.method1();
        sourceable1.method2();
    }
}
