package com.yh.yhandmlu.代理.laoma.chapter23.cglibProxy;

//import org.springframework.cglib.proxy.MethodInterceptor;

//import org.aopalliance.intercept.MethodInterceptor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * https://mp.weixin.qq.com/s?__biz=MzIxOTI1NTk5Nw==&mid=2650047517&idx=1&sn=85d88950bfda21106c58be536cdfc9cc&chksm=8fde21cfb8a9a8d946c1276f4c6e5374b167eb11168428333213c4164264d840bd38473f9d02&scene=38#wechat_redirect
 *
 * cglib
 *
 * 通过继承来实现，
 * 动态创建一个类「代理类」，这个类的父类是被代理的类
 * 代理类重写了父类的所有 public 非final方法；
 *
 * ==========================================
 * Java SDK 代理面向的是一组接口，为这些接口动态创建了一个实现类。接口具体实现逻辑是通过自定义的InvocationHandler实现的，实现是自定义的；
 *
 * cglib代理面向的是一个具体的类，动态的创建类一个新类，继承了这个具体类，重新了其 public非final的方法
 *
 *
 */
public class SimpleCglibProxy {

    /**
     * 被代理的类
     */
    static class RealService{
        public void sayHello(){
            System.out.println("cglib proxy");
        }
    }

    static class SimpleMethodInterception implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            System.out.println("in cglib...");

            Object invokeSuper = methodProxy.invokeSuper(o, objects);

            System.out.println("out cglib...");

            return invokeSuper;
        }


        /**
         * 生成代理类
         * @param cls
         * @param <T>
         * @return
         */
        public static <T> T getProxy(Class<T> cls){
            Enhancer enhance = new  Enhancer();
            enhance.setSuperclass(cls);
            enhance.setCallback(new SimpleMethodInterception());
            return (T)enhance.create();
        }

        public static void main(String[] arg){
            RealService proxy = getProxy(RealService.class);
            proxy.sayHello();
        }
    }

}
