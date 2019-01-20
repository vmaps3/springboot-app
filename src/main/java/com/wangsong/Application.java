package com.wangsong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;


@SpringBootApplication
@MapperScan("com.wangsong.*.dao")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }


}