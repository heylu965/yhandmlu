package com.yh.yhandmlu.泛型;

import lombok.Data;

@Data
public class Demo1 {

    private Object o;

    public Demo1(Object o) {
        this.o = o;
    }

    public void set(Object o){
        this.o = o;
    }
    public Object get(){
        return o;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1(new String("你好"));
        Object o1 = (String)demo1.get();
        System.out.println(o1);

        demo1.set(new Integer(1));
        Object o2 = (Integer)demo1.get();
        System.out.println(o2);
    }
}
