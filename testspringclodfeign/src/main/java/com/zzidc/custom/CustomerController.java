package com.zzidc.custom;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月8日 上午11:44:31
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@RestController
@Import(FeignClientsConfiguration.class)
public class CustomerController {
	
	 
	
	    @Autowired
	    private RestTemplate restTemplate; // HTTP 访问操作类，
	    
	    @Autowired
	    private HttpHeaders headerds;//jmxjava:jmxhello
	    
	   /**********************************通过feign调用使用spring security***************************************/
	    //1）去掉启动类上的@EnableFeignClients注解 
	    //2）去掉接口的@FeignClient的注解
	    //3）controller类添加注解@Import(FeignClientsConfiguration.class)
	    //4）去掉接口上的@Autowired注解，新增方法CustomerController(Decoder decoder, Encoder encoder, Client client, Contract contract)来实例化接口，注意这个方法需要添加@Autowired注解
	    private HelloRemote helloRemote;
	    @Autowired
	    public CustomerController(Decoder decoder, Encoder encoder, Client client, Contract contract){
	        this.helloRemote= Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
	                .requestInterceptor(new BasicAuthRequestInterceptor("jmxjava","jmxhello"))
	                .target(HelloRemote.class,"http://springms-gateway-zuul-fallback/");

	    }
	    /**********************************通过feign调用使用spring security***************************************/
	    @RequestMapping("/customer")
	    //通过Ribbon调用服务
	    @HystrixCommand(fallbackMethod = "customerFallback")//指定当服务不可用时调用的方法
	    public String customer() {
	    	//service-helloworld 为服务注册的name
	       /* String providerMsg = restTemplate.getForEntity("http://service-helloworld/info",
	        		
	                String.class).getBody();*/
	        String providerMsg = restTemplate.exchange("http://service-helloworld/info", HttpMethod.GET, new HttpEntity<Object>(headerds), String.class).getBody();
	        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
	    }
	    
	    public String  customerFallback() {
	    	return "service is not supported";
	    }
	    
//	    @Autowired
//	    private HelloRemote helloRemote;
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
