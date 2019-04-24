package com.yh.yhandmlu.设计模式.结构型.Flyweight;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<String,Shape> circleMap = new HashMap<>();

    public static Shape getShape(String color){
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("==========Creating circle of color : " + color);
        }
        return circle;
    }
}
