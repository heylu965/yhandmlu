package com.yh.yhandmlu.设计模式.创建型.builder;

import com.yh.yhandmlu.设计模式.创建型.builder.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐 = 汉堡+饮料
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0f;
        for (Item item : items){
            cost = cost + item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items){
            System.out.print("name: "+item.name());
            System.out.print(",Packing: "+ item.packing().pack());
            System.out.println(",price: "+item.price());
        }
    }
}
