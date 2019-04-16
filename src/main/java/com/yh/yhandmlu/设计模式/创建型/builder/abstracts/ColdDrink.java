package com.yh.yhandmlu.设计模式.创建型.builder.abstracts;

import com.yh.yhandmlu.设计模式.创建型.builder.Bottle;
import com.yh.yhandmlu.设计模式.创建型.builder.interfaces.Item;
import com.yh.yhandmlu.设计模式.创建型.builder.interfaces.Packing;

public abstract class ColdDrink implements Item {

    public Packing packing(){
        return new Bottle();
    }

    public abstract float price();
}
