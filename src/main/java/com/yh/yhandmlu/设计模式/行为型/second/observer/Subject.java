package com.yh.yhandmlu.设计模式.行为型.second.observer;

public interface Subject {

    void add(Observer observer);
    void del(Observer observer);
    void notifyAllObservers();

    void operator();


}
