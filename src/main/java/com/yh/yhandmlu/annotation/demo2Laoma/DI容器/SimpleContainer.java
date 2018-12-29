package com.yh.yhandmlu.annotation.demo2Laoma.DI容器;

import java.lang.reflect.Field;

public class SimpleContainer {

    public static <T> T getInstance(Class<T> cls) {
        try {
            T obj = cls.newInstance();

            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields){
                if (field.isAnnotationPresent(SimpleInject.class)){
                    if (!field.isAccessible()){
                        field.setAccessible(true);
                    }
                    Class<?> type = field.getType();
                    field.set(obj,getInstance(type));
                }
            }
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e){
            throw new RuntimeException();
        }
        return null;
    }

    public static void main(String[] arg){
        ServiceA instance = SimpleContainer.getInstance(ServiceA.class);
        instance.callB();

        ServiceB b = SimpleContainer.getInstance(ServiceB.class);
        if (instance.getB() != b){
            System.out.println("a.getB():"+instance.getB().toString());
            System.out.println("b:"+b.toString());
            System.out.println("SimpleContainer: difference instance");
        }

    }
}
