package com.yh.yhandmlu.设计模式.行为型.second.chainofresponsibility;

public class Test {

    public static void main(String[] args) {
        ChainPatternDemo demo = new ChainPatternDemo();
        AbstractLogger chainOfLogger = demo.getChainOfLogger();

        chainOfLogger.loggerMessage(AbstractLogger.INFO,"this is info message");

        chainOfLogger.loggerMessage(AbstractLogger.DEBUG,"this is debug message");

        chainOfLogger.loggerMessage(AbstractLogger.ERROR,"this is error message");
    }
}
