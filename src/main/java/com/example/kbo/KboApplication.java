package com.example.kbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.kbo.*"})
@MapperScan("com.example.kbo.mapperInter")
public class KboApplication {

    public static void main(String[] args) {
        SpringApplication.run(KboApplication.class, args);
    }

}
