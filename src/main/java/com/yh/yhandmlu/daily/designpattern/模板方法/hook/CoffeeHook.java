package com.yh.yhandmlu.daily.designpattern.模板方法.hook;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeHook extends CaffeineBeverageHook {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    public boolean customerWantsCondiment(){
        String input = getUserInput();
        if (input.toLowerCase().startsWith("y")){
            return true;
        }
        return false;
    }

    private String getUserInput(){
        String input = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n)?");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }

        if (StringUtils.isEmpty(input)){
            return "no";
        }
        return input;
    }
}
