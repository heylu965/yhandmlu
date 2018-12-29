package com.yh.yhandmlu.java8.lambda;

import lombok.Data;
import org.elasticsearch.common.io.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * http://www.ruanyifeng.com/blog/2012/04/functional_programming.html
 *
 * “面向过程”和“面向对象”的区别是“封装”。
 * “函数式”和“面向对象”的区别是“不使用外部状态”。
 */
class test{
    /**
     * -> 左边是参数，右边是函数体
     * @param arg
     */
    public static void main(String[] arg){
//        Demo1 d1 = new Demo1();
        Test1 test = s -> System.out.println("oneParam方法传递参数："+s);
        test.oneParam("我是传递的值");

        // t2 对象不是结果，是表示两个数字相加的结果
        Test2 t2 = (x,y)->x+y;
        System.out.println(t2.add(1,2));

        // Error:(19, 61) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
        // lambda也被称为闭包。
        String name = "jack";
//        name = "jack1";
        Runnable runnable = ()->System.out.println("hello "+name);
        runnable.run();
//        name = "jack1";

        /*
        List<String> l1 = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(l1);

        List<String> l2 = Stream.of("a","b","c").map(String->String.toUpperCase()).collect(Collectors.toList());
        System.out.println(l2);

        List<String> l3 = Stream.of("a","ab","cb").filter(o->o.contains("b")).collect(Collectors.toList());
        System.out.println(l3);

        List<Integer> l4 = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4)).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(l4);
        */

        List<Person> l5 = getPersons().stream().filter(o->o.getAge() > 15).collect(Collectors.toList());
        System.out.println(l5);

        Person p = getPersons().stream().min(Comparator.comparing(o->o.getAge())).get();
        System.out.println("min:"+p);

        Person p1 = getPersons().stream().max(Comparator.comparing(o->o.getAge())).get();
        System.out.println("max:"+p1);


        List<String> n1 = getPersons().stream().filter(o->o.getAge() > 13).map(Person::getName).collect(Collectors.toList());
        System.out.println(n1);

        /**去list集合中对象中的某个 属性转list */
        List<Integer> a1 = getPersons().stream().map(Person::getAge).collect(Collectors.toList());
        System.out.println(a1);

        /**list 转map*/
        // 这两种写法 有Duplicate key Person(age=10, name=n0) 异常
//        Map<Integer,Person> m1 = getPersons().stream().collect(Collectors.toMap(Person::getAge,o->o));
//        System.out.println(m1);

//        Map<Integer,Person> m2 = getPersons().stream().collect(Collectors.toMap(Person::getAge, Function.identity()));
//        System.out.println(m2);

        //解决办法 toMap有个重载方法，可以传入一个合并的函数来解决key冲突问题：

        Map<Integer,Person> m3 = getPersons().stream().collect(Collectors.toMap(Person::getAge,o->o,(k1,v1)->v1));
        System.out.println(m3);


        /**list 转 set*/
        Set<Integer> s1 = getPersons().stream().map(Person::getAge).collect(Collectors.toSet());
        System.out.println(s1);








    }

    public static List<Person> getPersons(){
        Person p0 = new Person();
        p0.setAge(10);
        p0.setName("n0");

        Person p1 = new Person();
        p1.setAge(10);
        p1.setName("n1");

        Person p2 = new Person();
        p2.setAge(12);
        p2.setName("n2");

        Person p3 = new Person();
        p3.setAge(14);
        p3.setName("n3");

        Person p4 = new Person();
        p4.setAge(18);
        p4.setName("n4");


        List<Person> ps = new ArrayList<>();
        ps.add(p0);
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        return ps;
    }
}

@Data
class Person {
    int age;
    String name;

}
public interface Test1 {

    void oneParam(String str);

}

interface Test2{
    int add(int a,int b);

}

