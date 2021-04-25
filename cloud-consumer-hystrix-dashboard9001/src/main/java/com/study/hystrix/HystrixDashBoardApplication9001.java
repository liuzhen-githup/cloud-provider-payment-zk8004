/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p></p>
 *
 * @EnableHystrixDashboard 开启Hystrix DashBoard 图形画界面功能
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/24 9:56 下午
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication9001.class,args);
    }
}
