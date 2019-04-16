package com.yh.yhandmlu.设计模式.创建型.factoryMethod.demo2;

public class Test {

    public static void main(String[] args) {
        MouseFactory mouseFactory = new HpMouseFactory();
        mouseFactory.createMouse().sayHi();

        MouseFactory mouseFactory1 = new DellMouseFactory();
        mouseFactory1.createMouse().sayHi();
    }
}
