package com.yh.yhandmlu.daily.thread.countdownlatch;

import org.junit.Test;

public class TestFixedThreadPool implements Runnable {

    private Demo demo;
    private int index;

    public TestFixedThreadPool(Demo demo,int index){
        this.demo = demo;
        this.index = index;
    }


    @Override
    public void run() {
        demo.setA(index);
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
