package com.example.protainshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.dao"})
public class ProtainShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtainShopApplication.class, args);
    }

}
