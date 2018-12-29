package com.yh.yhandmlu.annotation.demo1;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitColor {

    public enum Color{RED,GREEN,YELLOW}
    Color color() default Color.RED;
}
