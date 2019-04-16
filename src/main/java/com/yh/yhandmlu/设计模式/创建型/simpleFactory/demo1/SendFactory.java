package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo1;

import java.util.Objects;

public class SendFactory {

    public Send sendProducer(String type){
        if (Objects.equals("sms",type)){
            return new SendSms();
        }else if(Objects.equals("mail",type)){
            return new SendMail();
        }else {
            System.out.println("请输入正确类型");
            return null;
        }
    }

    /**
     * 静态工厂方法
     * @return
     */
    public static Send producerSms(){
        System.out.println("静态工厂方法");
        return new SendSms();
    }

    public static Send producerMail(){
        System.out.println("静态工厂方法");
        return new SendMail();
    }
}
