/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.hystrix.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 11:05 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_Ok(Integer id) {
       return "当前线程："+Thread.currentThread().getName()+" 业务执行成功 ，id： "+id +"，测试降级服务";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_Hystrix",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Failed(Integer id) {
        Integer len = id;
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //len = len /0;
        return "当前线程："+Thread.currentThread().getName()+ " 业务执行， 耗时："+ id + "秒 ， 测试降级服务";
    }



    /**
     * 服务降级方法
     * @return
     */
    public String paymentInfo_Hystrix(Integer id) {
        return "当前线程："+Thread.currentThread().getName()+ " 业务执行异常，请稍后重试 ,Id :" + id;
    }


    //-----------------------------------------服务熔断---------------------------------------------------

    /**
     *  服务熔断：
     *      简而言之，当服务在 10000 秒内 请求10次 失败率达到60% 则进行熔断操作
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_CircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled" ,value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求总数阈值，在时间窗口器请求次数满足设置的阈值才有资格进行熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败路达到多少跳闸
    })
    @Override
    public String paymentInfo_CircuitBreaker(Integer id) {
        //异常
        if(id > 10){
            throw new RuntimeException("ID 值输入异常......");
        }
        String uuid = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t"+"调用成功，UUID："+uuid;
    }

    /**
     * 服务熔断回调方法
     * @param id
     * @return
     */
    public String paymentInfo_CircuitBreaker_fallback(Integer id){
        return "服务端调用异常，进行熔断服务，paymentInfo_CircuitBreaker_fallback ，Id ：" +id;
    }


}
