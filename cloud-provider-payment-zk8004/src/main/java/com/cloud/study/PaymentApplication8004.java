/**
 * Copyright(c) 2018 asura
 */
package com.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p></p>
 *
 * @EnableDiscoveryClient 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/21 5:53 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class,args);
    }
}
