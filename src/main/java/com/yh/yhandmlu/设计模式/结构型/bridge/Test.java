package com.yh.yhandmlu.设计模式.结构型.bridge;

public class Test {

    /**
     * 就通过对Bridge类的调用，实现了对接口Sourceable的实现类SourceSub1和SourceSub2的调用
     * @param args
     */
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Sourceable sourceable = new SourceSub1();

        bridge.setSourceable(sourceable);
        bridge.method();

        System.out.println("---------");

        Sourceable sourceable1 = new SourceSub2();
        bridge.setSourceable(sourceable1);
        bridge.method();
    }

}
