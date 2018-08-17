package com.zzidc.sayhello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月16日 上午11:43:35
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(@RequestParam("name") String name) {
		return "Hello ,this is "+name;
	}
	
	@RequestMapping("/health")
	public Map<String,String> health() {
		Map<String,String> map = new HashMap<String, String>();
		map.put("status", "UP");
		return map;
	}
}
