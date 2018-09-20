package com.zzidc.util;

public class ResultInfo {

	private int code;
	private Object info;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public ResultInfo(int code, Object info) {
		super();
		this.code = code;
		this.info = info;
	}
	public ResultInfo() {
		super();
	}
	
}
