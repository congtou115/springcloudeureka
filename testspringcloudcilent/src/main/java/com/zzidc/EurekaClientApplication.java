package com.zzidc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月7日 下午9:07:03
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	
	
}
