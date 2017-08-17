package com.liuxch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liuxch.bean.User;
import com.liuxch.exception.DBException;
import com.liuxch.util.DBUtil;

public class UserDao {
	
	public static String SQL_GET_USER = "SELECT *FROM USER WHERE USER_NAME=?";
	
	public User getUserByName(String name) {
		User user = null;
		if (name == null || "" == name) {
			return null;
		}
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_GET_USER);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException();
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return user;
	}

}
