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
import com.liuxch.exception.ServiceException;
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
		
		try {
			User user = null;
			UserService userService = new UserService();
		    user = userService.Login(userName, userPwd);
		    HttpSession session = request.getSession();
			session.setAttribute("userName", user.getName());
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(
					request, response);
		} catch (ParameterException parameterException) {
			request.setAttribute("errMap", parameterException.getErrMap());
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
					response);
			return;
		} catch (ServiceException serviceException) {
			request.setAttribute("err_msg", serviceException.getMessage());
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
					response);
		}		

	}

	public void init() throws ServletException {

	}

}
