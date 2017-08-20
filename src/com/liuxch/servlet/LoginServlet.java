package com.liuxch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liuxch.Constants;
import com.liuxch.bean.User;
import com.liuxch.exception.ParameterException;
import com.liuxch.exception.ServiceException;
import com.liuxch.service.UserService;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String LOGIN_PAGE = "WEB-INF/login.jsp";

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_PAGE).forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constants.CONTENT_TYPE);
		String userName = request.getParameter(Constants.USER_NAME);
		String userPwd = request.getParameter(Constants.USER_PWD);
		
		try {
			User user = null;
			UserService userService = new UserService();
		    user = userService.Login(userName, userPwd);
		    HttpSession session = request.getSession();
			session.setAttribute(Constants.USER_NAME, user.getName());
			/*request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(
					request, response);*/
			response.sendRedirect(Constants.DASHBORAD_URL);
		} catch (ParameterException parameterException) {
			request.setAttribute(Constants.ERR_MAP, parameterException.getErrMap());
			request.getRequestDispatcher(LOGIN_PAGE).forward(request,
					response);
			return;
		} catch (ServiceException serviceException) {
			request.setAttribute(Constants.ERR_MSG, serviceException.getMessage());
			request.getRequestDispatcher(LOGIN_PAGE).forward(request,
					response);
		}		

	}

	public void init() throws ServletException {

	}

}
