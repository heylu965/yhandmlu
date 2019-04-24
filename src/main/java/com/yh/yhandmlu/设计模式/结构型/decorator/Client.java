package com.yh.yhandmlu.设计模式.结构型.decorator;

public class Client {

    public static void main(String[] args) {

        Transform transform = new Car();
        transform.move();

        System.out.println("========");
        Robot robot = new Robot(transform);
        robot.say();
        robot.move();

        System.out.println("========");
        Airplant airplant = new Airplant(transform);
        airplant.fly();
        airplant.move();
    }
}
