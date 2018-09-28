package com.springms.cloud.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.netflix.zuul.context.RequestContext;

public class HttpUtils {

	/**
	 * 
	 * [获取客户端请求真实IP地址]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月6日  上午11:25:13 <br>
	 * @param request
	 * @return <br>
	 */
	public static String getClientIpV4(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for"); 
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("X-Real-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        } 
        return ip; 
	}
	
	/**
	 * 
	 * [zuul过滤器返回错误信息]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月28日  上午11:55:26 <br>
	 * @param ctx
	 * @param map <br>
	 */
	public static void returnResult(RequestContext ctx,Map<String,Object> map) {
		ctx.set("isSuccess", false);
		ctx.setSendZuulResponse(false);//就算有此设置，也只是在pre类型过滤器执行完后停止转发
		Gson gson = new Gson();
		String json = gson.toJson(map);
		ctx.setResponseBody(json);
		ctx.setResponseStatusCode(403);
		ctx.getResponse().setContentType("application/json; charset=utf-8");
	}
	
}
