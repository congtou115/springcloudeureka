package com.zzidc.exception;

public class MyRutimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	
	public MyRutimeException() {
		super();
	}
	
	public MyRutimeException(int errorCode,String message) {
		super();
		this.errorCode = errorCode;
	}


	public MyRutimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,int errorCode) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}

	public MyRutimeException(String message, Throwable cause ,int errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public MyRutimeException(String message,int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public MyRutimeException(Throwable cause,int errorCode) {
		
		super(cause);
		this.errorCode = errorCode;
	}



	public int getErrorCode() {
		return errorCode;
	}



	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
