/**
 * Copyright(c) 2018 asura
 */
package com.study.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p></p>
 *
 * @EnableFeignClients 表示开启Feign注解及服务功能
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 9:01 上午
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication80.class,args);
    }
}
