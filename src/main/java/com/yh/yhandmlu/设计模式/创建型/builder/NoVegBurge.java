package com.yh.yhandmlu.设计模式.创建型.builder;

import com.yh.yhandmlu.设计模式.创建型.builder.abstracts.Burge;

public class NoVegBurge extends Burge {
    @Override
    public String name() {
        return "No Veg Burge";
    }

    @Override
    public float price() {
        return 2f;
    }
}
