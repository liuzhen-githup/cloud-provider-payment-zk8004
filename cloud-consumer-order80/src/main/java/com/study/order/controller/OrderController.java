/**
 * Copyright(c) 2018 asura
 */
package com.study.order.controller;


import com.study.order.robin.LoadBalancer;
import com.study.order.robin.impl.MyRoundRobin;
import con.study.common.domain.CommonResult;
import con.study.common.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * 通过 restTemplate 进行 httpClient 远程调用
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 9:20 下午
 */
@RestController
@Slf4j
public class OrderController {


    @Value("${server.service.address}")
    private String PAYMENT_URL;

    @Value("${cloud.server.name}")
    private String SERVER_NAME;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/save")
    public CommonResult<Payment> doCreate(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/entitySave")
    public CommonResult<Payment> doCreatePayment(@RequestBody Payment payment){
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/save",payment,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult doGetPayment(@PathVariable("id") Long id){
        return  restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/doRobin/{id}")
    public CommonResult doTestRobin(@PathVariable("id") Long id){
        //获取服务提供方服务总数
        List<ServiceInstance> instances = discoveryClient.getInstances(SERVER_NAME);
        ServiceInstance instance = loadBalancer.instance(instances);
        if(instances.isEmpty()){
            return null;
        }
        return  restTemplate.getForObject(instance.getUri()+"/payment/doRobin/"+id,CommonResult.class);
    }
}
