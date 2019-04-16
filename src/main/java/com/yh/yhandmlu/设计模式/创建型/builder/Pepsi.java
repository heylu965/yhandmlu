package com.yh.yhandmlu.设计模式.创建型.builder;

import com.yh.yhandmlu.设计模式.创建型.builder.abstracts.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi ...";
    }

    @Override
    public float price() {
        return 3f;
    }
}
