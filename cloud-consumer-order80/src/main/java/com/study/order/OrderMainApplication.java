/**
 * Copyright(c) 2018 asura
 */
package com.study.order;

import com.study.irule.MyIRuleRobin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <p></p>
 *
 * @EnableEurekaClient 将作为Eureka客户端
 * @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyIRuleRobin.class)
 *      表示访问CLOUD-PAYMENT-SERVICE服务将使用自定义组件 MyIRuleRobin.class 进行负载均衡
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 9:10 下午
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyIRuleRobin.class)
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class,args);
    }
}
