package com.yh.yhandmlu.daily.designpattern.模板方法;

public class Test {

    public static void main(String[] arg){

        Tea tea = new Tea();
        tea.prepareaRecipe();

        System.out.println("===================");
        Coffee coffee = new Coffee();
        coffee.prepareaRecipe();

    }
}
