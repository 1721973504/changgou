package com.yunlian.changgou.service.goods.config;

import com.yunlian.changgou.common.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class IdWorkerConfig {

    @Value("${workerId}")
    private int workerId;

    @Value("datacenterId")
    private int datacenterId;

    @Bean
    public IdWorker idworker(){
        return new IdWorker(workerId,datacenterId);
    }
}
