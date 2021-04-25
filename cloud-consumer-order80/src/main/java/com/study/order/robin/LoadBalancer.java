/**
 * Copyright(c) 2018 asura
 */
package com.study.order.robin;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/22 11:19 下午
 */
public interface LoadBalancer {

    /**
     * 轮询算法自定义
     * @param instances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> instances);
}
