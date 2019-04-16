package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo1;

public class SendMail implements Send{
    @Override
    public void send() {
        System.out.println("send mail...");
    }
}
