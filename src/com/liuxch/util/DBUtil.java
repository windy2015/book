package com.liuxch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.liuxch.exception.SQLRuntimeException;

public class DBUtil {
	
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
	
	public static final String USER_NAME = "root";
	
	public static final String USER_PWD = "dir13652";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		//1.加载驱动
		try {
			Class.forName(DRIVER_NAME);
			//2.获取连接
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PWD);
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new SQLRuntimeException();
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
	
/*	public static void main(String[] args){
		System.out.println("conn is "+DBUtil.getConnection());
	}*/

}
