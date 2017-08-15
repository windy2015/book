package com.liuxch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.liuxch.exception.SQLRuntimeException;

public class DBUtil {
	
	public static final String DRIVER_NAME = "";
	
	public static final String DB_URL = "";
	
	public static final String USER_NAME = "";
	
	public static final String USER_PWD = "";
	
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
	public void close(ResultSet rs, Statement st, Connection conn){
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

}
