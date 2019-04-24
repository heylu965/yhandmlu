package com.yh.yhandmlu.设计模式.结构型.bridge;

public class MyBridge extends Bridge{

    public void method(){
        getSourceable().method();
    }
}
