package com.yh.yhandmlu.设计模式.行为型.first.template;

public class PlusCalculator extends AbstractCalcuator{

    @Override
    int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
