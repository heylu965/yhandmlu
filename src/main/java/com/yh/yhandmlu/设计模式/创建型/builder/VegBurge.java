package com.yh.yhandmlu.设计模式.创建型.builder;

import com.yh.yhandmlu.设计模式.创建型.builder.abstracts.Burge;

public class VegBurge extends Burge {
    @Override
    public String name() {
        return "veg burge";
    }

    @Override
    public float price() {
        return 1f;
    }
}
