package com.springms.cloud.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
/**
 * 自定义Zuul回退机制处理器
 * 需要注意的是，此熔断器不支持以url配置的路由，必须使用serviceId的方式
 * @author Administrator
 *
 */
@Component
public class BootZuulFallbackHandler implements ZuulFallbackProvider{

	@Override
	public String getRoute() {
		return "sidecar";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            /**
             * 当 getRoute()代表的 微服务出现宕机后，客户端再请求时候就会返回 fallback 等字样的字符串提示；
             *
             * 但对于复杂一点的微服务，我们这里就得好好琢磨该怎么友好提示给用户了；
             *
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
            	JsonObject json = new JsonObject();
            	json.addProperty("code", "-1");
            	json.addProperty("info", "系统错误，请稍后再试");
            	json.addProperty("status", "false");
                return new ByteArrayInputStream(json.toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
	}

}
