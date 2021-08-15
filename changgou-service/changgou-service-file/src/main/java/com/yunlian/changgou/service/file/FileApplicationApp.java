package com.yunlian.changgou.service.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FileApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(FileApplicationApp.class,args);
    }
}
