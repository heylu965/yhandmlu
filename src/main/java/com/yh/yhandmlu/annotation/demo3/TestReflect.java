package com.yh.yhandmlu.annotation.demo3;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * https://mp.weixin.qq.com/s/94kf0dj5CtHBdfGi70Um6A
 * https://baike.xsoftlab.net/view/22.html
 */
public class TestReflect implements Serializable{

    public static void main(String[] arg){
        TestReflect testReflect = new TestReflect();

        // TODO 1、获得对象完整包名及类名
//        System.out.println(testReflect.getClass().getName());
        // com.yh.yhandmlu.annotation.demo3.TestReflect

        // TODO 2、实例化对象
        Class<?> clazz1 = null;
        Class<?> clazz2 = null;
        Class<?> clazz3 = null;

        // 常用方式
        try {
            clazz1 = Class.forName("com.yh.yhandmlu.annotation.demo3.TestReflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        clazz2 = new TestReflect().getClass();

        clazz3 = TestReflect.class;

//        System.out.println("类名称："+clazz1.getName());
//        System.out.println("类名称："+clazz2.getName());
//        System.out.println("类名称："+clazz3.getName());
        /*
        类名称：com.yh.yhandmlu.annotation.demo3.TestReflect
        类名称：com.yh.yhandmlu.annotation.demo3.TestReflect
        类名称：com.yh.yhandmlu.annotation.demo3.TestReflect
         */

        // TODO 3、获取对象的父类及接口

        try {
            Class<?> clazz4 = Class.forName("com.yh.yhandmlu.annotation.demo3.TestReflect");

            Class<?> superclass = clazz4.getSuperclass();
//            System.out.println("父类："+superclass.getName());
            // 父类：java.lang.Object

            Class<?>[] interfaces = clazz4.getInterfaces();
            for (int i = 0; i < interfaces.length;i++){
//                System.out.println("实现的接口["+(i+1)+"]s:"+interfaces[i].getName());
            }
            // 接口[1]s:java.io.Serializable

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // TODO 4、通过反射实例化一个对象

        // 4-1 实例化默认构造，set赋值
        try {
            Class<?> aClass = Class.forName("com.yh.yhandmlu.annotation.demo3.User");
            User u = (User)aClass.newInstance();
            u.setAge(11);
            u.setName("test");
            System.out.println(u);

            // 4-2 获取全部构造函数，使其构造函数赋值

            Constructor<?>[] constructors = aClass.getConstructors();
            for (int i=0;i<constructors.length;i++){
                Class<?>[] parameterTypes = constructors[i].getParameterTypes();
                System.out.print("cons["+i+"](");
                for (int j=0;j<parameterTypes.length;j++){
                    if (j == parameterTypes.length -1){
                        System.out.print(parameterTypes[j].getName());
                    }else {
                        System.out.print(parameterTypes[j].getName()+",");
                    }
                }
                System.out.println(")");
            }
            /*
            cons[0](java.lang.String,int)
            cons[1](java.lang.String)
            cons[2](int)
            cons[3]()
             */

            User uu0 = (User) constructors[0].newInstance("testName",1);
            System.out.println(uu0);

            User uu1 = (User) constructors[1].newInstance("testName2");
            System.out.println(uu1);

            /*
            User{name='testName', age=1}
            User{name='testName2', age=0}
             */

            System.out.println("==========");

            // TODO 通过反射机制调用某个类的方法
            Class<?> cla1 = Class.forName("com.yh.yhandmlu.annotation.demo3.TestReflect");
            Method method1 = cla1.getMethod("test1");
            method1.invoke(cla1.newInstance());

            Method method2 = cla1.getMethod("test2", int.class, String.class);
            method2.invoke(cla1.newInstance(),20,"testName");

            System.out.println("==========");
            // TODO 通过反射机制操作某个类的属性
            Class<?> cla2 = Class.forName("com.yh.yhandmlu.annotation.demo3.TestReflect");
            Object o = cla2.newInstance();
            // 可以直接对 private 的属性赋值
            Field field = cla2.getDeclaredField("name");
            field.setAccessible(true);
            field.set(o,"Java反射机制");
            System.out.println(field.get(o));


            System.out.println("==========");

            // TODO 获取类加载器
            TestReflect reflect = new TestReflect();
            System.out.println("类加载器："+reflect.getClass().getClassLoader().getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private String name;

    public void test1(){
        System.out.println("反射机制，调取某个类中的方法1");
    }
    public void test2(int age,String name){
        System.out.println("反射机制，调取某个类中的方法2");
        System.out.println("age:"+age+",name:"+name);
    }
}

@Data
class User{
    private String name;
    private int age;

    public User(){
        super();
    }
    public User(int age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}