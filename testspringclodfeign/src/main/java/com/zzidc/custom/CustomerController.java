package com.zzidc.custom;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	    @HystrixCommand(fallbackMethod = "customerFallback")//指定当服务不可用时调用的方法
	    public String customer() {
	    	//service-helloworld 为服务注册的name
	        String providerMsg = restTemplate.getForEntity("http://service-helloworld/info",
	                String.class).getBody();
	        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
	    }
	    
	    public String  customerFallback() {
	    	return "service is not supported";
	    }
	    
	    @Autowired
	    private HelloRemote helloRemote;
	    @RequestMapping("/consumerHello/{name}")
	    //通过Feign调用服务
	    public String index(@PathVariable("name") String name){
	        return helloRemote.sayHello(name);
	    }
	    
	    @RequestMapping("/serViceinfo")
	    public String info(){
	        return helloRemote.info();
	    }
	    @RequestMapping("/registed")
	    public List<Map<String, String>> registeredInfo(){
	    	return helloRemote.registered();
	    }

}
