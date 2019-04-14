package com.yh.yhandmlu.annotation.springOrder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(2)
public class Demo1Config {

    @Bean
    public Demo1Service demo1Service(){
        System.out.println("Demo1Service...");
        return new Demo1Service();
    }
}
