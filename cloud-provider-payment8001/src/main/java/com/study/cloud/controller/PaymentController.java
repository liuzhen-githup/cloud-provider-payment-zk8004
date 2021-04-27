/**
 * Copyright(c) 2018 asura
 */
package com.study.cloud.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.cloud.service.PaymentService;
import con.study.common.domain.CommonResult;
import con.study.common.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 12:32 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/save")
    public CommonResult doSavePay(@RequestBody Payment payment){
        int result = paymentService.doSavePayment(payment);

        log.info("*******插入结果：" + result);

        if(result>0){
            return  new CommonResult(200,"插入成功,serverPort :"+serverPort,result);
        } else {
            return  new CommonResult(444,"插入失败,serverPort :"+serverPort,null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.doFindPaymentById(id);

        log.info("*******查询结果：" + result);
        CommonResult commonResult = null;
        if(result != null){
            commonResult = new CommonResult(200,"查询成功,serverPort :"+serverPort,result);
        } else {
            commonResult = new CommonResult(444,"查询失败,serverPort :"+serverPort,null);
        }
        log.info("************** commonResult: "+commonResult);
        //2、创建jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json =  mapper.writeValueAsString(commonResult);
            System.out.println("********* json: "+ json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return commonResult;
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            log.info("***********element : "+ element);
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for (ServiceInstance instance : instances) {
                log.info("服务信息输出："+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            }
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/doRobin/{id}")
    public CommonResult getTestRobin(@PathVariable("id") Long id){
        Payment result = paymentService.doFindPaymentById(id);
        log.info("*******查询结果：" + result);
        if(result != null){
            return  new CommonResult(200,"查询成功,serverPort :"+serverPort,result);
        } else {
            return  new CommonResult(444,"查询失败,serverPort :"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String getTestTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }


}
