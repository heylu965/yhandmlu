package com.yh.yhandmlu.设计模式.行为型.first.strategy;

public abstract class AbstractCalculator {

    public int[] split(String exp,String opt){
        String[] split = exp.split(opt);
        int array[] = new int[2];
        array[0] = Integer.valueOf(split[0]);
        array[1] = Integer.valueOf(split[1]);

        return array;
    }
}
