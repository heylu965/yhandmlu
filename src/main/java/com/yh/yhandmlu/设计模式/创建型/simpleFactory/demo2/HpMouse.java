package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo2;

/**
 * 惠普厂商生成鼠标
 */
public class HpMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("Hp mouse...");
    }
}
