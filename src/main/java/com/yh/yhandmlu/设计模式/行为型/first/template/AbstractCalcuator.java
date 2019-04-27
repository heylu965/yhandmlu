package com.yh.yhandmlu.设计模式.行为型.first.template;

public abstract class AbstractCalcuator {

    public final int calculate(String exp,String opt){
        int[] split = split(exp, opt);
        return calculate(split[0],split[1]);
    }


    abstract int calculate(int num1,int num2);


    public int[] split(String exp,String opt){
        String[] split = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.valueOf(split[0]);
        arrayInt[1] = Integer.valueOf(split[1]);
        return arrayInt;
    }
}
