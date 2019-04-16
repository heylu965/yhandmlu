package com.yh.yhandmlu.设计模式.创建型.builder;

public class Test {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal meal = mealBuilder.vegMeal();

        System.out.println("veg......");
        meal.showItems();
        System.out.println("Total cost: "+meal.getCost());

        System.out.println("==============");

        Meal meal1 = mealBuilder.noVegMeal();
        System.out.println("noVeg......");
        meal1.showItems();
        System.out.println("Total cost: "+ meal1.getCost());
    }
}
