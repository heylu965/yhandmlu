package com.yh.yhandmlu.daily.designpattern.模板方法.hook;

public abstract class CaffeineBeverageHook {

    final void prepareaRecipe(){
        boilWater();
        pourInCup();
        brew();
        if (customerWantsCondiment()){
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }

    boolean customerWantsCondiment(){
        return true;
    }
}
