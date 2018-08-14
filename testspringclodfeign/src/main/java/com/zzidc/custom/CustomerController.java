package com.zzidc.custom;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月8日 上午11:44:31
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@RestController
public class CustomerController {
	    @Autowired
	    private RestTemplate restTemplate; // HTTP 访问操作类，
	    @RequestMapping("/customer")
	    //通过Ribbon调用服务
	    public String customer() {
	    	//service-helloworld 为服务注册的name
	        String providerMsg = restTemplate.getForEntity("http://service-helloworld:8762/info",
	                String.class).getBody();
	        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
	    }
	    
	    @Autowired
	    private HelloRemote helloRemote;
	    @RequestMapping("/consumerHello/{name}")
	    //通过Feign调用服务
	    public String index(@PathVariable("name") String name){
	        return helloRemote.sayHello(name);
	    }
	    
	    @RequestMapping("/info")
	    public String info(){
	        return " Hi,I am a consumer!";
	    }

}
