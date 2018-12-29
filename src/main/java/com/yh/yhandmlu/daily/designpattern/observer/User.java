package com.yh.yhandmlu.daily.designpattern.observer;

import lombok.Data;

@Data
public class User implements Observer{
    String name;
    String message;
    @Override
    public void update(String message) {
        this.message = message;
        readMessage(message);
    }

    public void readMessage(String message){
        System.out.println(name+" 接受消息："+message);
    }

}
