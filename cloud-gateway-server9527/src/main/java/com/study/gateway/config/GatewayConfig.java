/**
 * Copyright(c) 2018 asura
 */
package com.study.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * 自定义一个路由匹配 配置类
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/25 11:03 上午
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routers(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route_study",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
