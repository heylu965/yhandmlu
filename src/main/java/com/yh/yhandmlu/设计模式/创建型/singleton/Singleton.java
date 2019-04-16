package com.yh.yhandmlu.设计模式.创建型.singleton;

public class Singleton {

    private static Singleton instance;

    /**
     * 私有构造
     */
    private Singleton(){

    }

    /**
     * 饿汉式
     * 优点：
     * 1、线程安全；基于 classloader 机制避免了多线程的同步问题
     * 缺点：
     * 1、非延迟加载；
     */
    private static Singleton singleton = new Singleton();
    public static Singleton getSingleton(){
        return singleton;
    }

    /**
     * 懒汉式
     * 非线程安全
     * @return
     */
    public static Singleton getInstance(){
        if (instance == null){
            instance=  new Singleton();
        }
        return instance;
    }

    /**
     * 优点：
     * 1、线程安全
     * 2、延迟初始化，避免内存浪费
     * 缺点：
     * 必须加锁才能保证单例，加锁会影响效率；
     *
     * 分析：synchronized关键字锁住的是这个对象，性能会下降，每次调用getInstance1，都会加锁，
     * 其实代码可以优化，只有instance == null，即第一次创建时才加锁，看每次调用getInstance2方法；
     * @return
     */
    public static synchronized Singleton getInstance1(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * 优点：
     * 1、线程安全
     * 2、延迟加载
     *
     * 似乎 双检锁/双重校验锁（DCL，即 double-checked locking）这种方式没有问题；
     *
     * 但是，在构造函数这一步出现问题了，还是会出现问题？
     *
     * Java指令，在创建对象和赋值操作是两步进行的，即instance = new Singleton();这一步分开两步执行；
     * 并不能保证前后顺序；
     *
     * 1、a\b俩线程同时进到第一个if判断，
     * 2、a进入synchronized代码块，执行new操作；
     * 3、JVM内部优化机制，会先分配Singleton实例空白内存，并赋值给即instance，此时还没有实例化，a离开
     * 4、b进入synchronized代码块，发现instance ！= null，直接返回，其实还没实例化
     * 这时就会发生问题；
     *
     * 继续看后面代码；getInstance3()
     * @return
     */
    public static Singleton getInstance2(){
        if (instance == null){
            synchronized (instance){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    /**
     * 使用内部类来维护单例的实现，JVM内部机制能保证当一个类被加载时，这个类的加载过程是线程互斥的，
     * 这样当我们第一次调用getInstance3()的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕
     *
     * 这种方式能达到双检锁方式一样的功效，但实现更简单。
     * 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
     * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
     *
     * 这里只有调用了getInstance3方法，才会显式装载SingletonFactory，从而实例化 instance
     *
     * 优点：
     * 1、线程安全
     * 2、延迟加载
     */
    public static class SingletonFactory{
        private static Singleton singleton = new Singleton();
    }
    public static Singleton getInstance3(){
        return SingletonFactory.singleton;
    }



}

