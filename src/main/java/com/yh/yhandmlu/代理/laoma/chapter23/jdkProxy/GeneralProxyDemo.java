package com.yh.yhandmlu.代理.laoma.chapter23.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GeneralProxyDemo {

    static interface IServiceA{
        public void sayHello();
    }

    static class IServiceAImpl implements IServiceA{

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static interface IServiceB{
        public void fly();
    }

    static class IServiceBImpl implements IServiceB{

        @Override
        public void fly() {
            System.out.println("flying");
        }
    }

    static class MyInvocationHandler implements InvocationHandler{

        private Object realObj;

        public MyInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke start...");

            System.out.println(realObj.getClass().getSimpleName()+":"+method.getName());

            Object result = method.invoke(realObj, args);

            System.out.println(realObj.getClass().getSimpleName()+":"+method.getName());

            System.out.println("invoke    end...");

            return result;
        }
    }

    private static <T> T getProxy(Class<T> clz,T realObj){
        return  (T)Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), new MyInvocationHandler(realObj));
        // 这个是一组接口，clz就是一个接口class,第二个入参如下，上面的写法是有问题的；
//        return  (T)Proxy.newProxyInstance(clz.getClassLoader(), new Class<?>[] { clz }, new MyInvocationHandler(realObj));
    }

    public static void main(String[] arg){
        IServiceA a = new IServiceAImpl();
//        IServiceA proxy = getProxy(a.getClass(), a);
        IServiceA proxy = getProxy(IServiceA.class, a);
        proxy.sayHello();

        IServiceB b = new IServiceBImpl();
        IServiceB proxy1 = getProxy(IServiceB.class, b);

        proxy1.fly();

    }
}
