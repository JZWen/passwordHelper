package com.jzwen.passwordhelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.jzwen.passwordhelper.dao")
public class PasswordhelperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PasswordhelperApplication.class, args);
    }
}
