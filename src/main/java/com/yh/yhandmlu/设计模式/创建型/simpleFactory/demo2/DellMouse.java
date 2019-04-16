package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo2;

/**
 * 戴尔厂商生成鼠标
 */
public class DellMouse implements Mouse{

    @Override
    public void sayHi() {
        System.out.println("Dell mouse...");
    }
}
