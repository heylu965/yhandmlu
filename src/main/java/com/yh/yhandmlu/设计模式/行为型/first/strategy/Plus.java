package com.yh.yhandmlu.设计模式.行为型.first.strategy;

public class Plus extends AbstractCalculator implements ICalculator{

    @Override
    public int calculate(String exp) {
        int array[] = split(exp,"\\+");
        return array[0]+array[1];
    }
}
