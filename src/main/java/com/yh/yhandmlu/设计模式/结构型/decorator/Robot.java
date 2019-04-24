package com.yh.yhandmlu.设计模式.结构型.decorator;

public class Robot extends Changer{

    public Robot(Transform transform) {
        super(transform);
    }

    public void say(){
        System.out.println("i am robot and i am say...");
    }
}
