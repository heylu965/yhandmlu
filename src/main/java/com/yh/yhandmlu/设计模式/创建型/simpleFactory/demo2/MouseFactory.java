package com.yh.yhandmlu.设计模式.创建型.simpleFactory.demo2;

/**
 * 专门生成鼠标的工厂，可以有多个厂商生产
 */
public class MouseFactory {

    public Mouse createMouse(String name){
        if ("Dell".equals(name)){
            return new DellMouse();
        }else if ("Hp".equals(name)){
            return new HpMouse();
        }
        return null;
    }

    /**
     * 静态方法
     * @return
     */

    public static Mouse createHp(){
        System.out.println("static");
        return new HpMouse();
    }

    public static Mouse createDell(){
        System.out.println("static");
        return new DellMouse();
    }
}
