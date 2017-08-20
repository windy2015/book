package com.liuxch.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static final String DB_PROP_PATH = "db.properties";
	
	private static Properties prop;
	
	static{
		InputStream in = null;
		try {			
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(DB_PROP_PATH);
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static String getValueByKey(String name){
		return prop.getProperty(name);
	}	

}
