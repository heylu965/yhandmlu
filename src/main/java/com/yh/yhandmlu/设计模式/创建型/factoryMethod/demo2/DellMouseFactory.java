package com.yh.yhandmlu.设计模式.创建型.factoryMethod.demo2;

public class DellMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
