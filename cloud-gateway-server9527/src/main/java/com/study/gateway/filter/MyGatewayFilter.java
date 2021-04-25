/**
 * Copyright(c) 2018 asura
 */
package com.study.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

/**
 * <p></p>
 *
 * @Component
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/25 10:03 下午
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {

    /**
     * 类似SpringMvc的 modelAndView，每次的请求进行过滤参数，参数正常则放行
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**********com in MyGatewayFilter: " + ZonedDateTime.now());
        //获取请求参数是否带有uname参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("**********uname is null，非法用户！");
            //设置返回数据体 应答状态值失败
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
