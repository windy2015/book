package com.liuxch.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liuxch.bean.User;
import com.liuxch.util.DBUtil;

public class LoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		Map<String,String> errMap = new HashMap<String,String>();
		
		if("".equals(userName) || userName == null){
			errMap.put("name", "user name can not be null");
		}
		
		if("".equals(userPwd) || userPwd == null){
			errMap.put("pwd", "password can not be null");		
		}
		
		if(!errMap.isEmpty()){
			request.setAttribute("errMap", errMap);
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			return ;
		}
		
		String sql = "SELECT *FROM USER WHERE USER_NAME=?";		
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = DBUtil.getConnection();
		User user = null;
		
        try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);        
			rs = pst.executeQuery();     
			
			if(rs.next()){
				user = new User();
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, conn);
		}
        
        if(user == null){
        	request.setAttribute("err_msg", "用户名或密码不正确");
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);		
        	return ;
        }
        
        if(userPwd.equals(user.getPassword())){
        	HttpSession session = request.getSession();
        	session.setAttribute("userName", user.getName());
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			return;
        }		
    	request.setAttribute("err_msg","用户名或密码不正确");
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	
        
		
	}
	
	public void init() throws ServletException {
		
	}

}
