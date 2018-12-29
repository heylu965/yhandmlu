package com.yh.yhandmlu.annotation.demo1;

import java.lang.annotation.*;

/**
 * 水果名称
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD )
public @interface FruitName {

    String value() default "";
}
