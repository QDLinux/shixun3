package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("org.example.mapper") //将mapper的接口全部加载进spring boot
public class TliasWebManangermentApplication {
    public static void main(String[] args) {
        SpringApplication.run(TliasWebManangermentApplication.class);
    }
}