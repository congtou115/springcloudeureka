package com.zzidc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月7日 下午9:07:03
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@SpringBootApplication
@EnableEurekaClient
@EnableScheduling 
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
