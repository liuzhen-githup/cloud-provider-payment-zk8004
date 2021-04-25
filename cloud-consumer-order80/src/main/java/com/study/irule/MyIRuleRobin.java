/**
 * Copyright(c) 2018 asura
 */
package com.study.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * 自定义负载均衡算法
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/22 10:11 下午
 */
@Configuration
public class MyIRuleRobin {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
