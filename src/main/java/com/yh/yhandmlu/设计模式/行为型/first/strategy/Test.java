package com.yh.yhandmlu.设计模式.行为型.first.strategy;

public class Test {

    public static void main(String[] args) {

        ICalculator plus = new Plus();
        int calculate = plus.calculate("2+8");
        System.out.println(calculate);

        ICalculator multiply = new Multiply();
        int e = multiply.calculate("3*7");
        System.out.println(e);
    }
}
