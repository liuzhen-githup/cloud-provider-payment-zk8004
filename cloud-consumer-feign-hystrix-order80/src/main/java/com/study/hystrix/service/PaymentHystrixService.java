/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.hystrix.service.impl.PaymentFallBackServer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p></p>
 *  @FeignClient(value = "CLOUD-HYSTRIX-SERVER",fallback = PaymentFallBackServer.class)
 *    这种方式针对于调用 服务端业务 超时或异常，进行服务降级处理
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/24 10:24 上午
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-SERVER",fallback = PaymentFallBackServer.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String doTestHystrixSuccess(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/error/{id}")
    String doTestHystrixError(@PathVariable("id") Integer id);

    //-------------服务熔断--------------------------------------

    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    String doTestHystrix_CircuitBreaker(@PathVariable("id") Integer id);
}
