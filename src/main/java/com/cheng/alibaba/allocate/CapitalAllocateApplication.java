package com.cheng.alibaba.allocate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.cheng.alibaba.allocate.*")
public class CapitalAllocateApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CapitalAllocateApplication.class, args);
    }



}
