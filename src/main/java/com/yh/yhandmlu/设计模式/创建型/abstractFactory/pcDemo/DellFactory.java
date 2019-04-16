package com.yh.yhandmlu.设计模式.创建型.abstractFactory.pcDemo;

public class DellFactory implements PcFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBorad createKeyBorad() {
        return new DellKeyBorad();
    }
}
