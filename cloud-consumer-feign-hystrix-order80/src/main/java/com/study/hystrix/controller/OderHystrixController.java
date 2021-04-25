/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.hystrix.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @DefaultProperties(defaultFallback = "default_Hystrix_Error_Method");全局匹配服务降级方法
 *  1.当方法上 配有 @HystrixCommand 注解 且无 默认的回调方法则走 默认的全局配置方法
 *  2.当方法上配有@HystrixCommand 且有指定的 fallbackMethod 则走指定的回调降级服务
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/24 10:21 上午
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "default_Hystrix_Error_Method")
public class OderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String doTestHystrixSuccess(@PathVariable("id") Integer id){
        return paymentHystrixService.doTestHystrixSuccess(id);
    }

    /**
     *  @HystrixCommand 配置了 fallbackMethod 方法，则走自己配置的降级服务
     *   这个方式是针对与消费方自己业务处理失败时，进行服务降级
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/error/{id}")
    @HystrixCommand(fallbackMethod = "doTestHystrixFallBack",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            })
    public String doTestHystrixError(@PathVariable("id") Integer id){

//        try {
//            TimeUnit.SECONDS.sleep(id);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int len = id / 0;
        return paymentHystrixService.doTestHystrixError(id);
    }

    /**
     *  @HystrixCommand 没有配置指定的 fallbackMethod 方法，则走类配置的默认降级服务
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/error2/{id}")
    @HystrixCommand
    public String doTestHystrixError2(@PathVariable("id") Integer id){
        int len = id / 0;
        return paymentHystrixService.doTestHystrixError(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/error3/{id}")
    public String doTestHystrixError3(@PathVariable("id") Integer id){
        int len = id / 0;
        return paymentHystrixService.doTestHystrixError(id);
    }



    /**
     * 服务降级回调方法
     * @param id
     * @return
     */
    public String doTestHystrixFallBack(@PathVariable("id") Integer id){
        return "调用方请求服务方业务处理超时，异常，请检查服务是否正常！稍后再试, id:"+id;
    }


    /**
     * 全局默认降级服务方法
     * @return
     */
    public String  default_Hystrix_Error_Method(){
        return "类全局回调函数被调用.......";
    }
}
