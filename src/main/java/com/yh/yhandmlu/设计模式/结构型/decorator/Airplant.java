package com.yh.yhandmlu.设计模式.结构型.decorator;

public class Airplant extends Changer{

    public Airplant(Transform transform) {
        super(transform);
    }

    public void fly(){
        System.out.println("i am air plant and i am fly");
    }
}


