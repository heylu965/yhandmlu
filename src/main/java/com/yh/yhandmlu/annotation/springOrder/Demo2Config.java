package com.yh.yhandmlu.annotation.springOrder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(10)
public class Demo2Config {

    @Bean
    public Demo2Service demo2Service(){
        System.out.println("Demo2Service");
        return new Demo2Service();
    }
}
