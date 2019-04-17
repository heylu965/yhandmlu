package com.yh.yhandmlu.设计模式.结构型.adapter;

/**
 * 不继承Source类，而是持有Source类的实例
 */
public class Wrapper implements Targetable{

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("targetable method2...");
    }
}
