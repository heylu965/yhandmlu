package com.yh.yhandmlu.设计模式.结构型.Flyweight;

import lombok.Data;

@Data
public class Circle implements Shape{

    private int x;
    private int y;
    private int radius;

    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}
