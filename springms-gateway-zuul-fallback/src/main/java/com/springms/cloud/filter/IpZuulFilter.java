package com.springms.cloud.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.cloud.netflix.zuul.filters.pre.Servlet30WrapperFilter;
import org.springframework.cloud.netflix.zuul.filters.pre.ServletDetectionFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.oauth2.common.util.Jackson2JsonParser;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.netflix.discovery.converters.wrappers.CodecWrappers.JacksonJson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.springms.cloud.util.HttpUtils;

@Component
public class IpZuulFilter extends ZuulFilter{
	private static List<String> IP_WHITE_LIST = new ArrayList<String>();
	/**
	 * 
	 * [初始化白名单列表]
	 * 
	 * @author ZhangBinbin <br>
	 * @date   2018年9月6日  上午11:33:42 <br> <br>
	 */
	private void initIpWhiteList() {
		if(IP_WHITE_LIST == null) {
			IP_WHITE_LIST = new ArrayList<String>();
		}
		//内容不为空，说明已经赋值了，不需要重新操作，如果需要更新的话另说
		if(IP_WHITE_LIST.size() != 0) {
			return;
		}
		//可以用redis缓存等，目前写死用于测试
		IP_WHITE_LIST.add("192.168.101.70");
	}
	@Override
	public boolean shouldFilter() {
		return true;
	}
	@Override
	public Object run() {
		//获取当前访问IP
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String ip = HttpUtils.getClientIpV4(request);
		//查看白名单列表，然后对比当前ip是否在白名单内，可以用redis缓存等，目前写死用于测试
		initIpWhiteList();
		//直接抛出异常，结束过滤器处理流程
		//Assert.state(IP_WHITE_LIST.contains(ip), "此IP未添加白名单，禁止访问");
		//设置错误信息，这种情况下，其余的过滤器还会继续执行
		if(!IP_WHITE_LIST.contains(ip)) {
			Map<String,Object> map = new HashMap<>();
			map.put("code", "-1");
			map.put("info", "此IP未添加白名单，禁止访问");
			HttpUtils.returnResult(ctx, map);
		}
		return null;
	}
	

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
