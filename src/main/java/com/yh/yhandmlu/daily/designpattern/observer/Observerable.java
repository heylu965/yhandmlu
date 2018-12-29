package com.yh.yhandmlu.daily.designpattern.observer;

/**
 * 接口，具体可观察者 需要实现该接口
 * 可观察者
 * Subject[主题]
 */
public interface Observerable {

    /**
     * 注册为观察者
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 退出观察者
     * @param observer
     */
    public void quitObserver(Observer observer);

    /**
     * 通知观察者
     */
    public void notifyObserver();
}
