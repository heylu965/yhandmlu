package com.yh.yhandmlu.设计模式.行为型.first.template;

public class Test {

    public static void main(String[] args) {

        AbstractCalcuator calcuator = new PlusCalculator();
        String exp = "8+8";
        String opt = "\\+";
        int r1 = calcuator.calculate(exp,opt);
        System.out.println(r1);

        AbstractCalcuator calcuator1 = new MultiplyCalculator();
        String exp1 = "2*3";
        String opt1 = "\\*";
        int r2 = calcuator1.calculate(exp1,opt1);

        System.out.println(r2);

    }
}
