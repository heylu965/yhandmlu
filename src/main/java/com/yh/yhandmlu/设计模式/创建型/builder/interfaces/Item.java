package com.yh.yhandmlu.设计模式.创建型.builder.interfaces;

/**
 * 商品类目
 * 包括 实物名称
 * 包装类型
 * 价钱
 */
public interface Item {

    String name();

    Packing packing();

    float price();

}
