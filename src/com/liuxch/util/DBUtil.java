package com.liuxch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.liuxch.exception.DBException;

public class DBUtil {
	
	public static final String DRIVER_NAME = "driverName";
	
	public static final String DB_URL = "dbUrl";
	
	public static final String USER_NAME = "dbName";
	
	public static final String USER_PWD = "dbPwd";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			//1.加载驱动
			Class.forName(PropertiesUtil.getValueByKey(DRIVER_NAME));
			//2.获取连接
			conn = DriverManager.getConnection(PropertiesUtil.getValueByKey(DB_URL), PropertiesUtil.getValueByKey(USER_NAME), PropertiesUtil.getValueByKey(USER_PWD));
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new DBException();
		}		
		return conn;
	}
	
	/***
	 * 关闭资源，从小到大的顺序
	 */
	public static void close(ResultSet rs, Statement st, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
	
  /* public static void main(String[] args){
    	String name = PropertiesUtil.getValueByKey(DRIVER_NAME);
    	System.out.println("name is "+name);
		System.out.println("conn is "+DBUtil.getConnection());
	}*/

}
