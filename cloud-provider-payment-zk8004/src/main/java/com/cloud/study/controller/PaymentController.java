/**
 * Copyright(c) 2018 asura
 */
package com.cloud.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/21 5:55 下午
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zook")
    public String paymentMethod(){
        return "springcloud with zookeeper: " +serverPort +"\t " + UUID.randomUUID().toString();

    }
}
