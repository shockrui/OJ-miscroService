package com.shockrui.ojbackendjudgeservice;

import com.shockrui.ojbackendjudgeservice.rabbitmq.InitRabbitMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.shockrui")
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.shockrui.ojbackendserviceclient.feignClient")
public class OjBackendJudgeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OjBackendJudgeServiceApplication.class, args);
    }

}
