/**
 * Copyright(c) 2018 asura
 */
package com.study.cloud.service;


import con.study.common.domain.Payment;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 12:28 下午
 */
public interface PaymentService {

    /**
     * 数据插入
     * @param payment
     * @return
     */
    public int doSavePayment(Payment payment);


    /**
     * 数据查询
     * @param id
     * @return
     */
    public Payment doFindPaymentById(Long id);
}
