/**
 * Copyright(c) 2018 asura
 */
package com.study.feign.configFegin;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 *  这个一个OpenFeign的日志配置类
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 9:29 下午
 */
@Configuration
public class FeignConfig {


    /**
     * 开启openFeign 全局日志输出
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
