/**
 * Copyright(c) 2018 asura
 */
package com.cloud.order.controller;

import con.study.common.domain.CommonResult;
import con.study.common.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/21 7:13 下午
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL="http://cloud-privider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zook")
    public String doCreate(String name){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/zook/",String.class);
    }

}
