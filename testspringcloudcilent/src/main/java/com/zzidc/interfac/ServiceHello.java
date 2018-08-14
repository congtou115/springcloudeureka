package com.zzidc.interfac;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月14日 上午10:33:52
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@FeignClient(name="service-helloworld")
public interface ServiceHello {

}
