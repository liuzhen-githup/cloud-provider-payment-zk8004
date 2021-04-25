/**
 * Copyright(c) 2018 asura
 */
package com.study.cloud.service.impl;

import com.study.cloud.dao.PaymentDao;
import com.study.cloud.service.PaymentService;
import con.study.common.domain.Payment;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 12:28 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int doSavePayment(Payment payment){
        return paymentDao.savePayment(payment);
    }
    @Override
    public Payment doFindPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
