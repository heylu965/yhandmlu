package com.yh.yhandmlu.设计模式.行为型.first.strategy;

public class Multiply extends AbstractCalculator implements ICalculator{

    @Override
    public int calculate(String exp) {
        int a[] = split(exp,"\\*");
        return a[0]*a[1];
    }
}
