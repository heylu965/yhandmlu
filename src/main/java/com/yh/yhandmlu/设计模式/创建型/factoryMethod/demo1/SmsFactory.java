package com.yh.yhandmlu.设计模式.创建型.factoryMethod.demo1;

public class SmsFactory implements Factory {

    @Override
    public Send factory() {
        return new SendSms();
    }
}
