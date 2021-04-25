/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix.service.impl;

import com.study.hystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/24 3:25 下午
 */
@Component
@Service
public class PaymentFallBackServer implements PaymentHystrixService {
    @Override
    public String doTestHystrixSuccess(Integer id) {
        return "doTestHystrixSuccess method is fallback.....";
    }

    @Override
    public String doTestHystrixError(Integer id) {
        return "doTestHystrixError method is fallback.....";
    }

    @Override
    public String doTestHystrix_CircuitBreaker(Integer id) {
        return "doTestHystrix_CircuitBreaker method is fallback....";
    }
}
