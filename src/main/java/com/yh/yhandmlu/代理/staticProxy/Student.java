package com.yh.yhandmlu.代理.staticProxy;


/**
 * 被代理的类对象
 */
public class Student implements Person {
    @Override
    public void say(String name, int age) {
        System.out.println("My Name "+name+",age is "+age);
    }
}


/**
 * 代理对象
 *
 * 静态代理，只是在代理对象中引入了被代理对象，进而获取被代理对象的方法；
 */
class ProxyTest implements Person{

    private Person p;

    public ProxyTest(Person p){
        this.p = p;
    }


    @Override
    public void say(String name, int age) {
        System.out.println("proxy class start");

        p.say("yanghai",23);

        System.out.println("proxy class end");
    }
}

/**
 * 测试代码
 */
class Test{

    public static void main(String[] arg){

        Student student = new Student();

        ProxyTest proxyTest = new ProxyTest(student);

        proxyTest.say("proxy",20);

    }
}
