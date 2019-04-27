package com.yh.yhandmlu.设计模式.行为型.second.observer;

/**
 * 具体的目标，即被观察者
 */
public class SubjectMy extends SubjectAbstract{

    @Override
    public void operator() {
        System.out.println("update ....");
        notifyAllObservers();
    }
}
