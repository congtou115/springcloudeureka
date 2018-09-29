package com.zzidc.exception;

public class JsonResult {

	private int code ;
	private String info;
	
	private static JsonResult result = new JsonResult();
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	private static JsonResult getInstance(int code ,String info) {
		result.setCode(code);
		result.setInfo(info);
		return result;
	}
	 
	public static JsonResult errorException(MyRutimeException e) {
		return getInstance(e.getErrorCode(),e.getMessage());
	}

}
