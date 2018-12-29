package com.yh.yhandmlu.daily.designpattern.模板方法.hook;

public class Test {

    public static void main(String[] arg){

        CoffeeHook coffeeHook = new CoffeeHook();
        TeaHook teaHook = new TeaHook();


        System.out.println("Making coffee ...");
        coffeeHook.prepareaRecipe();

        System.out.println("==============");
        System.out.println("Making tea ...");
        teaHook.prepareaRecipe();
    }

}
