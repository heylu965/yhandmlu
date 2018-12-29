package com.yh.yhandmlu.daily.designpattern.observer;

/**
 * 观察者
 * 具体观察者要实现该接口
 */
public interface Observer {

    /**
     * 观察者收到消息 做更新操作
     * @param message
     */
    public void update(String message);
}
