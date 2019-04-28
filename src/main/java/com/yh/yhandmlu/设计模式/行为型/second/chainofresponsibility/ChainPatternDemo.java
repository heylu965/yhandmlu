package com.yh.yhandmlu.设计模式.行为型.second.chainofresponsibility;

public class ChainPatternDemo {

    public static AbstractLogger getChainOfLogger(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);
        return errorLogger;
    }
}
