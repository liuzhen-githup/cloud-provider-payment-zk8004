/**
 * Copyright(c) 2018 asura
 */
package com.study.cloud.dao;

import con.study.common.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 12:11 下午
 */
@Mapper
public interface PaymentDao {

    /**
     * 插入数据
     * @param payment
     * @return
     */
    public int savePayment(Payment payment);

    /**
     * Id 查找数据
     * @param id
     * @return
     */
    public Payment getPaymentById(@PathParam("id") Long id);

}
