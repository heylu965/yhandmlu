package com.yh.yhandmlu.annotation.demo1;

import lombok.Data;

@Data
public class Apple {

    @FruitName("apple")
    private String appleName;
    @FruitColor(color = FruitColor.Color.RED)
    private String appleColor;
    @FruitProvider(id = 1,name = "供货商名称",address = "供货商地址")
    private String appleProvider;
}
