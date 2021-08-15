package com.yunlian.changgou.gateway.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class WebApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApplicationApp.class,args);
    }
}
