package com.zzidc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [说明/描述]
 * @author ZhangBinBin
 * @date 2018年8月16日 上午11:21:35
 * @company Gainet
 * @version 1.0
 * @copyright copyright (c) 2018
 */
@SpringBootApplication
@EnableSidecar
@RestController
public class SidecarApplication {
	public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }
	
	/*@RequestMapping("/health")
	public Map<String,String> health(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("status", "UP");
		return map;
	}*/
	/****************************************************************************************
	 一、集成异构微服务系统到 SpringCloud 生态圈中(比如集成 nodejs 微服务)（正常情况测试）：

	 1、编写 application.yml 文件，添加应用程序的注解 EnableSidecar 配置；
	 2、启动 springms-discovery-eureka 模块服务，启动1个端口；
	 3、启动 springms-gateway-zuul-fallback 模块服务，启动1个端口；
	 4、启动 springms-sidecar 模块服务，启动1个端口；
	 5、启动 springms-node-service 微服务，启动1个端口；

	 6、新起网页页签，输入 http://localhost:8205/ 正常情况下是能看到 "欢迎来到简单异构系统之 nodejs 服务首页" 信息被打印出来；
	 7、新起网页页签，然后输入 http://localhost:8205/health.json，正常情况下是能看到 "{"status":"UP"}" 信息被打印出来；

	 总结一：nodejs 微服务，自己访问自己都是正常的；

	 8、新起网页页签，输入 http://localhost:8200/springms-sidecar/ 正常情况下是能看到 "欢迎来到简单异构系统之 nodejs 服务首页" 信息被打印出来；
	 9、新起网页页签，然后输入 http://localhost:8200/springms-sidecar/health.json，正常情况下是能看到 "{"status":"UP"}" 信息被打印出来；

	 总结二：通过在yml配置文件中添加 sidecar 属性，就可以将异构系统添加到SpringCloud生态圈中，完美无缝衔接；
	 ****************************************************************************************/





	/****************************************************************************************
	 二、集成异构微服务系统到 SpringCloud 生态圈中(比如集成 nodejs 微服务)（除了包含异构微服务外，还添加 Ribbon 模块电影微服务）：

	 1、编写 application.yml 文件，添加应用程序的注解 EnableSidecar 配置；
	 2、启动 springms-discovery-eureka 模块服务，启动1个端口；
	 3、启动 springms-gateway-zuul-fallback 模块服务，启动1个端口；
	 4、启动 springms-sidecar 模块服务，启动1个端口；
	 5、启动 springms-consumer-movie-ribbon 模块服务，启动1个端口；
	 6、启动 springms-node-service 微服务，启动1个端口；

	 7、新起网页页签，输入 http://localhost:8205/ 正常情况下是能看到 "欢迎来到简单异构系统之 nodejs 服务首页" 信息被打印出来；
	 8、新起网页页签，然后输入 http://localhost:8205/health.json 正常情况下是能看到 "{"status":"UP"}" 信息被打印出来；

	 总结一：nodejs 微服务，自己访问自己都是正常的；

	 9、新起网页页签，输入 http://localhost:8200/springms-sidecar/ 正常情况下是能看到 "欢迎来到简单异构系统之 nodejs 服务首页" 信息被打印出来；
	 10、新起网页页签，然后输入 http://localhost:8200/springms-sidecar/health.json 正常情况下是能看到 "{"status":"UP"}" 信息被打印出来；
	 

	 总结二：通过 Zuul 代理模块，统一入口路径，也可以从 zuul 上成功访问异构系统；

	 11、新起网页页签，输入 http://localhost:8010/sidecar/ 正常情况下是能看到 "欢迎来到简单异构系统之 nodejs 服务首页" 信息被打印出来；
	 12、新起网页页签，然后输入 http://localhost:8010/sidecar/health.json 正常情况下是能看到 "{"status":"UP"}" 信息被打印出来；

	 总结三：给 springms-consumer-movie-ribbon 微服务添加几个方法，也可以成功访问以异构系统，可见利用 SpringCloud 来集成异构系统简便了很多；
	 ****************************************************************************************/
}
