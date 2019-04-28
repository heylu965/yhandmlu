package com.yh.yhandmlu.设计模式.行为型.second.chainofresponsibility;

public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("InfoLogger...."+message);
    }
}
