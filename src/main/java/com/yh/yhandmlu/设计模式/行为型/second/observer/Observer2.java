package com.yh.yhandmlu.设计模式.行为型.second.observer;

/**
 * 具体观察者
 */
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("Observer2 has received...");
    }
}
