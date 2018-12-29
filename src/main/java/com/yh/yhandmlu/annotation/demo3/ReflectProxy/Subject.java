package com.yh.yhandmlu.annotation.demo3.ReflectProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Subject {

    public String say(String name,int age);
}

class RealSubject implements Subject{

    @Override
    public String say(String name, int age) {
        return "name:"+name+",age:"+age;
    }


    public static void main(String[] arg) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Subject subject = (Subject) myInvocationHandler.bind(new RealSubject());
        String say = subject.say("yanghai", 26);
        System.out.println(say);

    }
}

/**
 * 在java中有三种类类加载器。
 *
 * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
 *
 * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
 *
 * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
 *
 * 如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
 *
 *
 */
class MyInvocationHandler implements InvocationHandler{

    private Object obj = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
}
