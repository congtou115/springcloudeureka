package com.zzidc.hystrix;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zzidc.custom.HelloRemote;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月14日 上午10:37:04
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@Component
public class HelloRemoteHystrix implements HelloRemote{

	@Override
	public String sayHello(String name) {
		return "sorry "+name+" there is a error happend";
	}


	@Override
	public String info() {
		
		return "sorry,the info you asked is 机密文件";
	}

	@Override
	public List<Map<String, String>> registered() {
		
		return null;
	}

}
