package com.yh.yhandmlu.设计模式.结构型.decorator;

public class Changer implements Transform{

    public Transform transform;

    public Changer(Transform transform) {
        this.transform = transform;
    }

    @Override
    public void move() {
        transform.move();
    }
}
