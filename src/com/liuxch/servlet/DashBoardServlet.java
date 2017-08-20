package com.liuxch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuxch.Constants;

public class DashBoardServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4895750962110005698L;
	
	public static final String WELCOME_PAGE = "WEB-INF/welcome.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constants.CONTENT_TYPE);
		request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
	}

	
}
