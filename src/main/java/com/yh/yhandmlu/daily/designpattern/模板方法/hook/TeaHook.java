package com.yh.yhandmlu.daily.designpattern.模板方法.hook;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaHook extends CaffeineBeverageHook {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
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
        System.out.println("would you like lemon with your tea (y/n) ?");
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
