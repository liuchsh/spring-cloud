package com.cs.ln.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * TODO 写注释
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
@SpringBootApplication
// 最新版本的springcloud-netfix-eureka不需要这个注解了，只要有依赖就可以
//@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class BizServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(BizServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
