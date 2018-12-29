package com.yh.yhandmlu.annotation.demo2Laoma.DI容器;

public class ServiceA {

    @SimpleInject
    ServiceB b;

    public void callB(){
        b.action();
    }

    public ServiceB getB(){
        return b;
    }
}
