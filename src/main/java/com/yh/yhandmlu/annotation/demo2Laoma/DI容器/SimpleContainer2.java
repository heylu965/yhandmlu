package com.yh.yhandmlu.annotation.demo2Laoma.DI容器;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 先检查 类型是否单例
 * 是单例，直接创建
 * 不是单例，检查缓存，
 *      缓存中有值，直接返回
 *      缓存中没有，直接创建，放缓存
 */
public class SimpleContainer2 {

    private static Map<Class<?>,Object> intances = new ConcurrentHashMap<>();

    public static <T> T createInstance(Class<T> cls){
        try {
            T t = cls.newInstance();
            for(Field field : cls.getDeclaredFields()){
                if (field.isAnnotationPresent(SimpleInject.class)){
                    if (!field.isAccessible()){
                        field.setAccessible(true);
                    }
                    Class<?> type = field.getType();
                    field.set(t,getInstance(type));
                }
            }
            return t;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public static <T> T getInstance(Class<T> cls){
        // 是否单例
        boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
        if (!singleton){
            return createInstance(cls);
        }

        Object o = intances.get(cls);
        if (o != null){
            return (T)o;
        }

        synchronized (cls){
            o = intances.get(cls);
            if (o == null){
                o = createInstance(cls);
                intances.put(cls,o);
            }
        }
        return (T)o;
    }


    public static void main(String[] arg){

        ServiceA a = getInstance(ServiceA.class);
        a.callB();

        ServiceB b = getInstance(ServiceB.class);
        if (a.getB() == b){
            System.out.println("a.getB():"+a.getB());
            System.out.println("b:"+b.toString());

            System.out.println("SimpleContainer2: same instance");
        }
    }
}
