package com.sxl.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.service.UserService;

public class CheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String username = request.getParameter("username");
		//����service����
		UserService userService = new UserService();
		boolean isExit = false;
		try {
			isExit = userService.checkUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		response.getWriter().write("{\"isExist\":"+isExit+"}");      
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}