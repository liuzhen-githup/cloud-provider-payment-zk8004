/**
 * Copyright(c) 2018 asura
 */
package com.study.order.robin.impl;

import com.study.order.robin.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 * 自定义一个负载均衡轮询算法
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/22 11:22 下午
 */
@Component
public class MyRoundRobin implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 自定义CAS自旋锁
     *  原理：
     *      从内存中默认atomicInteger=0开始，前端请求一次 做一次 +1；
     *      当达到整型最大数时，计数从0开始
     * @return
     */
    public final int getIncrementAdd(){
        int current = 0, next = 0;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("前端请求次数计数，next： "+ next);
        return next;
    }


    /**
     * 请求数 % 服务器总数 = 服务列表下标 - 负载均衡算法
     *  根据服务列表下标获取服务信息返回
     *
     *
     * @param instances
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = this.getIncrementAdd() %  instances.size();
        ServiceInstance serviceInstance = instances.get(index);
        return serviceInstance;
    }
}
