package com.yh.yhandmlu.设计模式.创建型.builder;

public class MealBuilder {

    public Meal vegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurge());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal noVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new NoVegBurge());
        meal.addItem(new Pepsi());
        return meal;
    }
}
