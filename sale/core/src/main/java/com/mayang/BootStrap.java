package com.mayang;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mayang.mapper")
public class BootStrap {

    public static void main(String[] args){
        SpringApplication.run(BootStrap.class, args);
    }

}
