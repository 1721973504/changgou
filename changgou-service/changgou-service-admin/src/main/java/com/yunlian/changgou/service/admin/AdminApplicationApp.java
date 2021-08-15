package com.yunlian.changgou.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplicationApp.class,args);
    }
}
