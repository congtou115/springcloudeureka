package com.zzidc.hystrix;

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
	public String makeAHello() {
		return "sorry  there is a error happend";
	}

}
