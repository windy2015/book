package com.liuxch.exception;

public class ServiceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5119020930329454846L;

	//服务异常代码
	private int code;
	
	//服务异常信息
	private String message;
	
	public ServiceException(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public ServiceException(String message){	
		this.message = message;
	}	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
