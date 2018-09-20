package com.zzidc.util;


import java.util.Collection;
import java.util.Map;


/**
 * 工具类
 * @author Administrator
 *
 */
public class ObjectUtils {

	/**
	 * 
	 * [判断对象是否为空]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月12日  下午3:35:04 <br>
	 * @param obj
	 * @return <br>
	 */
	public static boolean isEmpty(Object obj) {
		if(obj == null) {
			return true;
		}
		if(obj instanceof String) {
			if(obj.equals("")) {
				return true;
			}
		}
		if(obj instanceof Collection<?>) {
			Collection<?> coll = (Collection<?>) obj;
			return coll.isEmpty();
		}
		return false;
	}
	
	
	/**
	 * 
	 * [转化obj为String类型，如果为空则返回空字符串,否则转成json字符串]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月13日  下午1:35:33 <br>
	 * @param obj
	 * @return <br>
	 */
	public static String stringOf(Object obj) {
		if(obj == null) {
			return "";
		}
		if(obj instanceof String) {
			return obj.toString();
		}
		return String.valueOf(obj);
	}
	
	
	/**
	 * 
	 * [将obj强转为long]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月13日  下午2:03:10 <br>
	 * @param obj
	 * @param defValue 默认返回值
	 * @return <br> 如果obj可以转化为long则返回转化后的obj，否则返回defValue
	 */
	public static long longOf(Object obj,long defValue) {
		if(isEmpty(obj)) {
			return defValue;
		}
		try {
			return Long.valueOf(obj.toString());
		} catch (Exception e) {
			return defValue;
		}
	}
	
	/**
	 * 
	 * [将obj强转为int]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月13日  下午2:03:10 <br>
	 * @param obj
	 * @param defValue 默认返回值
	 * @return <br> 如果obj可以转化为int则返回转化后的obj，否则返回defValue
	 */
	public static int intOf(Object obj,int defValue) {
		if(isEmpty(obj)) {
			return defValue;
		}
		try {
			return Integer.valueOf(obj.toString());
		} catch (Exception e) {
			return defValue;
		}
	}
	
	/**
	 * 
	 * [从map中获取指定key的value值并做泛型转化]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月13日  下午1:43:54 <br>
	 * @param map
	 * @param key
	 * @return <br> 如果map、key为null或者map中不包含这个key返回null，其他情况返回强转类型
	 */
	public static <T> T getVal(Map<String,Object> map,String key) {
		if(isEmpty(key)) {
			return null;
		}
		if(isEmpty(map)) {
			return null;
		}
		if(isEmpty(map.get(key))) {
			return null;
		}
		return (T) map.get(key);
	}
	
	/**
	 * 
	 * [判断传入字符是不是合法的ip]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月17日  上午10:30:54 <br>
	 * @param ip
	 * @return <br>
	 */
	public static boolean isIp(String ip) {
		if(isEmpty(ip)) {
			return false;
		}
		String reg = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		
		return ip.matches(reg);
	}
}
