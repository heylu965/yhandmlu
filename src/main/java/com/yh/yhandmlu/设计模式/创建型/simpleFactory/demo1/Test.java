package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo1;

public class Test {

    public static void main(String[] args) {
        SendFactory sf = new SendFactory();
        Send send = sf.sendProducer("sms");
        if (send != null){
            send.send();
        }


        send = sf.sendProducer("mail");
        if (send != null){
            send.send();
        }


        send = sf.sendProducer("mail1");
        if (send != null){
            send.send();
        }
        System.out.println("====================");

        Send producerMail = SendFactory.producerMail();
        producerMail.send();

        Send producerSms = SendFactory.producerSms();
        producerSms.send();
    }
}
