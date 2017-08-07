package com.liuxch.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		System.out.println("userName === "+userName);
		System.out.println("userPwd === "+userPwd);
		//验证用户名和密码
		if("admin".equals(userName)){
			if("123456".equals(userPwd)){
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			}else{
				request.setAttribute("err_msg", "用户名或密码不正确");
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);				
			}
		}else{
			request.setAttribute("err_msg","用户名或密码不正确");
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
	}
	
	public void init() throws ServletException {
		
	}

}
