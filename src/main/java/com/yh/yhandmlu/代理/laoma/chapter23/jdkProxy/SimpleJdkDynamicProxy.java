package com.yh.yhandmlu.代理.laoma.chapter23.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 特点
 * 代理类和被代理类必须实现同一个接口
 * 只能为接口创建代理，这是局限，返回的代理对象只能是接口类型（具体可以跟下源码java.lang.reflect.Proxy#newProxyInstance）
 */
public class SimpleJdkDynamicProxy {

    static interface IService{
        public void sayHello();
    }

    static class RealService implements IService{

        @Override
        public void sayHello() {
            System.out.println("say hello");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler{

        private Object realObj;

        public SimpleInvocationHandler(Object realObj){
            this.realObj = realObj;
        }

        /**
         * @param proxy 表示代理对象本身，需要注意，它不是被代理的对象，这个参数一般用处不大
         * @param method 表示正在被调用的方法
         * @param args 表示方法的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("in my proxy class");
            Object invoke = method.invoke(realObj, args);
            System.out.println("leavel my proxy class");
            return invoke;
        }
    }

    public static void main(String[] arg){

        IService iService = new RealService();
        ClassLoader classLoader = iService.getClass().getClassLoader();
        Class<?>[] interfaces = iService.getClass().getInterfaces();
        SimpleInvocationHandler invocationHandler = new SimpleInvocationHandler(iService);
        /**
         * 这里类型转换，只能转成 interfaces 中的某一个接口类型
         */
        IService proxyInstance = (IService)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        proxyInstance.sayHello();
    }
}
