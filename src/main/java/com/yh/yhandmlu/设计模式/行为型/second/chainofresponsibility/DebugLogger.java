package com.yh.yhandmlu.设计模式.行为型.second.chainofresponsibility;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DebugLogger...."+message);
    }
}
