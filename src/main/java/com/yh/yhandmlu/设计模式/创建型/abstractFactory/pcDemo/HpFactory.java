package com.yh.yhandmlu.设计模式.创建型.abstractFactory.pcDemo;

public class HpFactory implements PcFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBorad createKeyBorad() {
        return new HpKeyBorad();
    }
}
