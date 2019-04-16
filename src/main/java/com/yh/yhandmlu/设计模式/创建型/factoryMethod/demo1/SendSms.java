package com.yh.yhandmlu.设计模式.创建型.factoryMethod.demo1;

public class SendSms implements Send{

    @Override
    public void send() {
        System.out.println("factory method ,send sms ...");
    }
}
