/**
 * Copyright(c) 2018 asura
 */
package com.study.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/26 11:10 下午
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     * 将远程服务器上的属性注入
     */
    @Value("${spring.config.name}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
