package com.yh.yhandmlu.设计模式.创建型.builder;

import com.yh.yhandmlu.设计模式.创建型.builder.interfaces.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
