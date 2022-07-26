package com.zhj.esdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhj.esdemo")
public class EsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsDemoApplication.class, args);
    }

}
