package com.yh.yhandmlu.设计模式.创建型.factoryMethod.demo1;

public class Test {

    public static void main(String[] args) {
        Factory factory = new MailFactory();
        Send mailSend = factory.factory();

        mailSend.send();


        factory = new SmsFactory();
        Send smsSend = factory.factory();
        smsSend.send();
    }
}
