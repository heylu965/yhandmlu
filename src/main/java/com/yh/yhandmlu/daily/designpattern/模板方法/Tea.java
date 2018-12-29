package com.yh.yhandmlu.daily.designpattern.模板方法;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
       System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }


}
