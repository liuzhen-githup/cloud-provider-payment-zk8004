/**
 * Copyright(c) 2018 asura
 */
package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p></p>
 * @EnableEurekaClient 表示将作为eureka客户端服务
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 11:53 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMainApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainApplication8001.class,args);
    }
}
