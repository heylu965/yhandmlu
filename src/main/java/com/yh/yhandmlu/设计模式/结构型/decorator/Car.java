package com.yh.yhandmlu.设计模式.结构型.decorator;

public class Car implements Transform{
    @Override
    public void move() {
        System.out.println("i am car and i am move...");
    }

    public Car() {
        System.out.println("i am car constructor...");
    }
}
