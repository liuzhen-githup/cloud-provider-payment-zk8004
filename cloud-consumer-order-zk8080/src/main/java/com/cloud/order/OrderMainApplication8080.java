/**
 * Copyright(c) 2018 asura
 */
package com.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/21 7:12 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication8080.class,args);
    }
}
