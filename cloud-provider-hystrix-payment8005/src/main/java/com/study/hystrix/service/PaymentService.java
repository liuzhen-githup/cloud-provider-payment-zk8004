/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix.service;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 11:05 下午
 */
public interface PaymentService {

    /**
     * 正常服务调用
     * @param id
     * @return
     */
    String paymentInfo_Ok(Integer id);

    /**
     * 服务调用异常
     * @param name
     * @return
     */
    String paymentInfo_Failed(Integer name);


    //----------------------------------------服务熔断----------------------------------------------------

    /**
     * 服务熔断
     * @param id
     * @return
     */
    String paymentInfo_CircuitBreaker(Integer id);

}
