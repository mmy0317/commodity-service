package com.mayang;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mayang.mapper")
public class CoreBootStrap {

    public static void main(String[] args){
        SpringApplication.run(CoreBootStrap.class, args);
    }

}
