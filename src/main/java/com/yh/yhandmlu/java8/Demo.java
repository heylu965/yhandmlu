package com.yh.yhandmlu.java8;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    @Data
    class Person{
        private Long id;
        private String name;
        private Integer age;
    }


    public List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(20);
        p1.setName("jack1");
        p1.setId(1L);

        Person p2 = new Person();
        p2.setAge(22);
        p2.setName("jack2");
        p2.setId(2L);

        personList.add(p1);
        personList.add(p2);
        return personList;
    }

    @Test
    public void test_foreach(){
        List<Person> personList = getPersonList();
        personList.forEach((o)->{
            System.out.println(o);
        });
    }

    @Test
    public void test1(){
        Person p1 = new Person();
        p1.setAge(20);
        p1.setName("jack1");
        p1.setId(1L);

        Person p2 = new Person();
        p2 = p1;

        System.out.println(p1);
        System.out.println(p2);

        p2.setName("test");

        System.out.println(p1);
        System.out.println(p2);


        System.out.println("******************");
        String[] s = {"1","2"};
        String[] s1 = s;

        Arrays.stream(s).forEach((o)->{System.out.println(o);});
        System.out.println("+++++++");
        s1[1] = "3";
        Arrays.stream(s1).forEach((o)->{System.out.println(o);});

    }

    public static void main(String[] arg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始执行线程:"+Thread.currentThread().getName());
            }
        }).start();


        new Thread(()->{
            System.out.println("lambda开始执行线程:"+Thread.currentThread().getName());
        }).start();
    }
}
