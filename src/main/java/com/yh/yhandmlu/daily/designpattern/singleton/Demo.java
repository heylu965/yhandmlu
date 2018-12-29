package com.yh.yhandmlu.daily.designpattern.singleton;

import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;

public class Demo {

    public static void main(String[] arg){
        String p = "100.01";
        BigDecimal b = new BigDecimal(p);
        System.out.println(Long.parseLong(b.toString()));

//        Person person = new Person("m",1);

    }

    @Data
    class Person extends Humanbeing{
        private String name;
        private int age;

        Person(String name,int age){
            this.name = name;
            this.age = age;
        }

        Person(){
            this.name = name;
            this.age = age;
        }
    }

    @Data
    class Humanbeing{

        /**
         * public private protected
         */
        public int hight;

    }

    @Test
    public void test(){

        Person person = new Person();
        person.setAge(12);
        person.setName("zhangmenglu");
        person.setHight(185);
        System.out.println(person.toString());

    }
}
