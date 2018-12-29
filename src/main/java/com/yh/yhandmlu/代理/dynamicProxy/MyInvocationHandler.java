package com.yh.yhandmlu.代理.dynamicProxy;

import com.yh.yhandmlu.代理.staticProxy.Person;
import com.yh.yhandmlu.代理.staticProxy.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public MyInvocationHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("my Invocation invoke start");
        System.out.println("proxy:"+proxy.getClass().getName());
        System.out.println("method:"+method.getName());
        for (Object o : args){
            System.out.println("arg:"+o);
        }

        // 通过反射调用，被代理对象的方法
        method.invoke(obj,args);

        System.out.println("my Invocation invoke end");

        return null;
    }

    public static void main(String[] arg){
        // 被代理对象
        Student student = new Student();

        //这一句是生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获取被代理类的类加载器
//        ClassLoader classLoader = Thread.currentThread().getClass().getClassLoader();

        // TODO Exception in thread "main" java.lang.IllegalArgumentException: interface com.yh.yhandmlu.代理.staticProxy.Person is not visible from class loader
        // TODO 该异常是创建代理时加载接口的类加载器与创建时传入的不一致。

        ClassLoader classLoader = student.getClass().getClassLoader();

        // 获取被代理类实现的接口
        Class<?>[] interfaces = student.getClass().getInterfaces();

        // 获取被代理类的委托类，都是通过委托类来获取被代理类的方法 通过invoke方法
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(student);

        //生成代理类
        Person proxyInstance = (Person)Proxy.newProxyInstance(classLoader, interfaces, myInvocationHandler);

        proxyInstance.say("yanghai proxy ",100);

        System.out.println("end");

    }
}
