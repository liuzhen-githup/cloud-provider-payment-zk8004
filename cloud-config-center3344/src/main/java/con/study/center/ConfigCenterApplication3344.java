/**
 * Copyright(c) 2018 asura
 */
package con.study.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p></p>
 *
 * @EnableConfigServer 激活配置功能
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/26 9:55 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterApplication3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication3344.class,args);
    }
}
