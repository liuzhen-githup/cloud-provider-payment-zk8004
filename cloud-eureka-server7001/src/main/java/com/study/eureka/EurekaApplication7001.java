/**
 * Copyright(c) 2018 asura
 */
package com.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p></p>
 *
 * @EnableEurekaServer 标志这个服务是注册中心，开启Eureka服务
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/21 12:20 上午
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7001.class,args);
    }
}
