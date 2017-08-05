package com.liuxch.servlet;

import java.io.IOException;

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
		System.out.println("userName === "+userName);
		System.out.println("userPwd === "+userPwd);
		//用常量模拟
		if("admin".equals(userName)){
			if("123456".equals(userPwd)){
				request.setAttribute("err_msg", "用户名或密码不正确");
				request.getRequestDispatcher("web-inf/login.jsp").forward(request, response);
			}else{
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("web-inf/welcome.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("err_msg", "用户名或密码不正确");
			request.getRequestDispatcher("web-inf/login.jsp").forward(request, response);
		}
		
	}
	
	public void init() throws ServletException {
		
	}

}
