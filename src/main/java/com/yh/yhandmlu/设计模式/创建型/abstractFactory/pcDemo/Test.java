package com.yh.yhandmlu.设计模式.创建型.abstractFactory.pcDemo;

import com.yh.yhandmlu.设计模式.创建型.abstractFactory.pcDemo.*;

public class Test {

    public static void main(String[] args) {

        PcFactory pcFactory = new DellFactory();
        KeyBorad keyBorad = pcFactory.createKeyBorad();
        keyBorad.papa();

        Mouse mouse = pcFactory.createMouse();
        mouse.sayHi();

        System.out.println("======");

        PcFactory pcFactory1 = new HpFactory();
        KeyBorad keyBorad1 = pcFactory1.createKeyBorad();
        keyBorad1.papa();

        Mouse mouse1 = pcFactory1.createMouse();
        mouse1.sayHi();

    }
}
