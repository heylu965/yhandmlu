package com.yh.yhandmlu.daily.designpattern.observer;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observerable{

    /**
     * 装具体的观察者
     */
    List<Observer> list = null;
    String message = "";

    WechatServer(){
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void quitObserver(Observer observer) {
        if (list.contains(observer)){
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        if (!CollectionUtils.isEmpty(list)){
            for (Observer observer : list){
                observer.update(message);
            }
        }
    }

    public void setMessage(String message){
        this.message = message;
        System.out.println("微信服务器更新消息......"+message);
        notifyObserver();
    }
}
