/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
 * @Date 2021/4/23 11:19 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String doTestHystrixSuccess(@PathVariable("id") Integer id){
       return paymentService.paymentInfo_Ok(id);
    }


    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String doTestHystrixError(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Failed(id);
    }



    //-----------------------服务熔断--------------------------------------

    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    public String doTestHystrix_CircuitBreaker(@PathVariable("id") Integer id){
      return paymentService.paymentInfo_CircuitBreaker(id);
    }

}
