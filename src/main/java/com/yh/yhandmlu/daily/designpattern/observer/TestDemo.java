package com.yh.yhandmlu.daily.designpattern.observer;

public class TestDemo {

    public static void main(String[] arg){

        User u1 = new User();
        u1.setName("z1");
        User u2 = new User();
        u2.setName("z2");

        WechatServer server = new WechatServer();
        server.registerObserver(u1);
        server.registerObserver(u2);

        server.setMessage("你好");

        System.out.println("---------");
        server.quitObserver(u1);
        server.setMessage("我是007");
    }
}
