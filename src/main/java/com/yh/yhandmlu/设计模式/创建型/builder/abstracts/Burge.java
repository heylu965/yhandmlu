package com.yh.yhandmlu.设计模式.创建型.builder.abstracts;

import com.yh.yhandmlu.设计模式.创建型.builder.Wrapper;
import com.yh.yhandmlu.设计模式.创建型.builder.interfaces.Item;
import com.yh.yhandmlu.设计模式.创建型.builder.interfaces.Packing;

public abstract class Burge implements Item {

    public Packing packing(){
        return new Wrapper();
    }

    public abstract float price();

}
