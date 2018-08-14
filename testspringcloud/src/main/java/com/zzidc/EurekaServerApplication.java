package com.zzidc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月7日 下午6:29:30
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
	
	
}
