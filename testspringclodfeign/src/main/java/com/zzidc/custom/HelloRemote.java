package com.zzidc.custom;

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
//name:远程服务名，即spring.application.name配置的名称
@FeignClient(name= "service-helloworld",fallback  = HelloRemoteHystrix.class)
public interface HelloRemote {
	//需要匹配服务提供者接口名称
	@RequestMapping(value = "/producerHello")
	public String sayHello(@RequestParam(value="name") String name);
}
