package com.yh.yhandmlu.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] arg) {

        Demo demo = new Demo();

        Class c = Demo.class;

        for (Annotation method : c.getAnnotations()){
            Class<? extends Annotation> annotationType = method.annotationType();

            System.out.println(annotationType);

        }
        System.out.println("================");
        for (Method method : c.getMethods()){
            Todo todo = method.getAnnotation(Todo.class);
            System.out.println(todo);
            System.out.println(todo.author());
            System.out.println(todo.priority());
            System.out.println(todo.status());
        }


    }

    @Todo(priority = Todo.Priority.HIGH, status = Todo.Status.NOT_START, author = "YH")
    public void test1() {

    }


}
