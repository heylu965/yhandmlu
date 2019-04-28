package com.yh.yhandmlu.设计模式.行为型.second.chainofresponsibility;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogger...."+message);
    }
}
