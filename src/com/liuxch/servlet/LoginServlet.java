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
import com.liuxch.exception.DBException;
import com.liuxch.exception.ParameterException;
import com.liuxch.service.UserService;
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
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		
		User user = null;
		
		try {
			UserService userService = new UserService();
		    user = userService.Login(userName, userPwd);
		} catch (ParameterException e) {
			request.setAttribute("errMap", e.getErrMap());
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
					response);
			return;
		}

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", user.getName());
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(
					request, response);
			return;
		}
		request.setAttribute("err_msg", "用户名或密码不正确");
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
				response);

	}

	public void init() throws ServletException {

	}

}
