package com.shockrui.ojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.shockrui.ojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.shockrui")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.shockrui.ojbackendserviceclient.feignClient"})
public class OjBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjBackendUserServiceApplication.class, args);
    }

}
