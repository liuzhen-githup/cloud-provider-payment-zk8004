/**
 * Copyright(c) 2018 asura
 */
package com.study.feign.service;

import con.study.common.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p></p>
 * 按照OpenFeign开发指南，将定义一个接口；接口增加@FeignClient注解标识这是一个远程服务调用接口
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 9:16 上午
 */

@Component
@FeignClient(name = "${cloud.server.name}")
public interface PaymentFeignConfig {

    /**
     * 远程服务调用
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * openFeign超时测试
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String getTestTimeout();

}
