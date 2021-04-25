/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p></p>
 *
 * @EnableHystrix 开启服务降级熔断功能
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/24 10:22 上午
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApplication80.class, args);
    }
}
