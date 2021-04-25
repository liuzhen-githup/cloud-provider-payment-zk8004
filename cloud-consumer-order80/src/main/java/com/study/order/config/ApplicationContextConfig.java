/**
 * Copyright(c) 2018 asura
 */
package com.study.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p></p>
 * 自定义一个配置类
 *  创建一个 RestTempLate 组件
 *
 *  @LoadBalanced 注解赋予RestTemplate负载均衡的功能 默认轮询
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 9:27 下午
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}

