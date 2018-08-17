package com.zzidc.custom;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzidc.hystrix.HelloRemoteHystrix;

/**
 * [客户端接口]
 * @author ZhangBinBin
 * @date 2018年8月8日 下午1:49:26
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@Service
//name:远程服务名，即spring.application.name配置的名称或者可以通过网关代理
@FeignClient(name= "springms-gateway-zuul-fallback",fallback  = HelloRemoteHystrix.class)//还可以使用fallbackfactory 能够获取具体的调用失败原因
public interface HelloRemote {
	//需要匹配服务提供者接口名称
	@RequestMapping(value = "/user/producerHello")
	public String sayHello(@RequestParam(value="name") String name);
	
	@RequestMapping(value = "/user/info")
	public String info();
	
	@RequestMapping(value = "/user/registered")
	public List<Map<String, String>> registered();
}
