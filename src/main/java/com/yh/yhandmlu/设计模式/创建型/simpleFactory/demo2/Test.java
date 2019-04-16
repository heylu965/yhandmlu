package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo2;

public class Test {

    public static void main(String[] args) {

        MouseFactory factory = new MouseFactory();
        Mouse dell = factory.createMouse("Dell");
        dell.sayHi();

        Mouse hp = factory.createMouse("Hp");
        hp.sayHi();

        System.out.println("==========");

        MouseFactory.createDell().sayHi();

        MouseFactory.createHp().sayHi();

    }
}
