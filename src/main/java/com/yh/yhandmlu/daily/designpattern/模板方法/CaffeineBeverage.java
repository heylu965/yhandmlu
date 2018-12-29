package com.yh.yhandmlu.daily.designpattern.模板方法;

public abstract class CaffeineBeverage {

    final void prepareaRecipe(){
        boilWater();
        pourInCup();
        brew();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }
}
