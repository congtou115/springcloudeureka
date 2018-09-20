package com.zzidc;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月8日 上午10:57:09
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class FeignConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}
	
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	@Bean
	public HttpHeaders getHeader() {
	    HttpHeaders headers=new HttpHeaders();
	    String auth="jmxjava:jmxhello";//认证的原始信息
	    byte[] encodeAuth=Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));//将原始认证信息进行Base64加密
	    String authHeader="Basic "+new String(encodeAuth);//加密后的认证信息要与Basic有个空格
	    headers.set("Authorization", authHeader);
	    return headers;
	}
}
