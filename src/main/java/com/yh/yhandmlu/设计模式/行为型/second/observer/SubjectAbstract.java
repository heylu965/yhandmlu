package com.yh.yhandmlu.设计模式.行为型.second.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  维护者要被通知的观察者的集合
 */
public abstract class SubjectAbstract implements Subject{

    private List<Observer> observers = new ArrayList<>();


    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            iterator.next().update();
        }
    }

}
