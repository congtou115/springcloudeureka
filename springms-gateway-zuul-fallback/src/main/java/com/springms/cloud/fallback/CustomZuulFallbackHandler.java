package com.springms.cloud.fallback;


import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义Zuul回退机制处理器。
 * 可以继承一个已经实现ZuulFallbackProvider接口的类，来共用某些方法，然后重新getRoute()以指定要回退的服务名字
 *
 */
@Component
public class CustomZuulFallbackHandler extends BootZuulFallbackHandler {

    /**
     * 返回值表示需要针对此微服务做回退处理（该名称一定要是注册进入 eureka 微服务中的那个 serviceId 名称）；
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "service-helloworld";
    }
}