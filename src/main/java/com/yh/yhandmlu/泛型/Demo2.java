package com.yh.yhandmlu.泛型;

public class Demo2<T> {
    private T t;
    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }

    public Demo2(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Demo2<Integer> demo2 = new Demo2(new Integer(1));

        System.out.println(demo2.get());

//        demo2.set(new String("你好"));
//        System.out.println(demo2.get());
    }
}
