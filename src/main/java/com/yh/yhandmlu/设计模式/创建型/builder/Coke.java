package com.yh.yhandmlu.设计模式.创建型.builder;

import com.yh.yhandmlu.设计模式.创建型.builder.abstracts.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke...";
    }

    @Override
    public float price() {
        return 2f;
    }
}
