package com.bjpowernode.mp06;


import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan(value = "com.bjpowernode.mp06.mapper")
@EnableScheduling
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class Mp06Application {

    public static void main(String[] args) {
        SpringApplication.run(Mp06Application.class, args);
    }

}
