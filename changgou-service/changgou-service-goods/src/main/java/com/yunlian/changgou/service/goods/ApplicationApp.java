package com.yunlian.changgou.service.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.yunlian.changgou.service.goods.mapper")
public class ApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationApp.class,args);
    }
}
