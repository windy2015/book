package com.liuxch.exception;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3058553131848101265L;
	
	private Map<String, String> errMap = new HashMap<String, String>();

	public void setErrMap(Map<String, String> errMap) {
		this.errMap = errMap;
	}	
	
	public Map<String, String> getErrMap() {
		return errMap;
	}

	public void addErrField(String key, String value){
		this.errMap.put(key, value);
	}	

}
