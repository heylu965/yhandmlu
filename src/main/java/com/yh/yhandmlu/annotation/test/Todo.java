package com.yh.yhandmlu.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {

    public enum Priority {LOW,MEDIUM,HIGH}
    public enum Status{START,NOT_START}
    String author() default "yanghai";

    Priority priority() default Priority.MEDIUM;
    Status status() default Status.START;

}
