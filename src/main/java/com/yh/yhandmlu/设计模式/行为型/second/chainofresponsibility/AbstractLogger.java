package com.yh.yhandmlu.设计模式.行为型.second.chainofresponsibility;

public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void loggerMessage(int level,String message){

        if (this.level <= level){
            write(message);
        }else {
            if (nextLogger != null){
                nextLogger.loggerMessage(level,message);
            }
        }

    }
    protected abstract void write(String message);
}
