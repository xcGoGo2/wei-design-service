package com.design.weidesignservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.design.weidesignservice.mapper")
public class SpringbootDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDesignApplication.class, args);
    }
}
