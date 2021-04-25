/**
 * Copyright(c) 2018 asura
 */
package com.study.feign.controller;

import com.study.feign.service.PaymentFeignConfig;
import con.study.common.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 9:32 上午
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignConfig paymentFeignConfig;

    @GetMapping("/consumer/payment/getFeign/{id}")
    public CommonResult getPaymentFeignById(@PathVariable("id") Long id){
       return paymentFeignConfig.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String getTestTimeOut(){
        return paymentFeignConfig.getTestTimeout();
    }
}
