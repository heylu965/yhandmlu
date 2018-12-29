package com.yh.yhandmlu.annotation.demo1;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitProvider {

    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
