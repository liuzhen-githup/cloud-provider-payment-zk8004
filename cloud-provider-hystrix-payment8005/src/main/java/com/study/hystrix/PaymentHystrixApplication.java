/**
 * Copyright(c) 2018 asura
 */
package com.study.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 11:00 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class PaymentHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，Springcloud升级后的坑
     * ServletRegistrationBean 因为 springBoot的默认路径不是 "/hystrix.stream"
     * 只要在自己的项目里配置上 下面的servlet 即可
     * @return
     */
    @Bean
    public ServletRegistrationBean getRegistration(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
