package com.yh.yhandmlu.annotation.demo3.simple.factory;

public interface Car {

    public void driver();
}

class Benz implements Car {

    @Override
    public void driver() {
        System.out.println("driver Benz");
    }
}

class Bmw implements Car {

    @Override
    public void driver() {
        System.out.println("driver Bmw");
    }
}

/**
 * https://www.cnblogs.com/yumo1627129/p/7197524.html
 * <p>
 * 简单工厂模式又称静态工厂模式。
 * 简单工厂模式由工厂类角色、抽象产品角色和具体产品角色组成。
 * 工厂类角色是本模式的核心，含有一定的商业逻辑和判断逻辑，它往往由一个具体类实现。
 * 抽象产品角色一般是具体产品继承的父类或者实现的接口，由接口或者抽象类来实现。
 * 具体产品角色由一个具体类实现。
 */
class SimpleCarFactory {

    public static Car getInstance(String carName) throws Exception {
        if (carName.equalsIgnoreCase("Benz")) {
            return new Benz();
        } else if (carName.equalsIgnoreCase("Bmw")) {
            return new Bmw();
        } else {
            throw new Exception("不支持改种车型");
        }
    }

    public static void main(String[] arg) {
        try {
            Car benz = SimpleCarFactory.getInstance("benz");
            benz.driver();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
