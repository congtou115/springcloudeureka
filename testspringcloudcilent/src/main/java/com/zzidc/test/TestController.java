package com.zzidc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月14日 上午10:29:28
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@RestController
@Api("测试eureka客户端")
public class TestController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
	String port;
	@ApiOperation(value="主页",notes="主页，测试返回当前实例的端口号")
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "hello world from port " + port;
	}
	@ApiOperation(value="获取客户端实例详情", notes="获取与当前客户端注册服务名称相同的所有实例信息")
	@RequestMapping(value="/info",method=RequestMethod.GET)
    public List<ServiceInstance> info(){
		List<ServiceInstance> list = discoveryClient.getInstances("service-helloworld");
        return list;
    }
	
	@ApiOperation(value="打招呼",notes="传入名字，然后就自动生成打招呼语句")
	@ApiImplicitParam(name="name",value="名字",paramType="query",defaultValue="Tom",dataType="String")
	@RequestMapping(value="/producerHello",method=RequestMethod.GET)
    public String producerHello(@RequestParam("name") String name){
        return "hello " + name + "，this is service-helloworld messge";
    }
	
	@RequestMapping(value="/registered",method=RequestMethod.GET)
	@ApiOperation(value="获取已注册的服务列表",notes="获取已注册的服务列表（服务名与当前服务一致）")
	@ResponseBody
	public List<Map<String, String>> getRegistered(){
        List<ServiceInstance> list = discoveryClient.getInstances("service-helloworld");
        ServiceInstance si = discoveryClient.getInstances(env.getProperty("spring.application.name")).get(0);
        List<Map<String,String>> services = new ArrayList<Map<String,String>>();
        Map<String,String> metadata = si.getMetadata();
		Set<String> keys = new HashSet<String>();
		for(String key:metadata.keySet()) {
			if(key.indexOf(".")>-1) {
				keys.add(key.substring(0,key.indexOf(".")));
			}
		}
		for (String key : keys) {
			Map<String,String> service = new HashMap<String,String>();
			for (String keyStr : metadata.keySet()) {
				if(keyStr.startsWith(key+".")) {
					service.put(keyStr.replace(key+".", ""),metadata.get(keyStr) );
				}
			}
			services.add( service);
		}
    	return services;
    }
}
