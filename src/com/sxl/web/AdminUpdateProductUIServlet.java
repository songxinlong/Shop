package com.sxl.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.domain.Category;
import com.sxl.domain.Product;
import com.sxl.service.ProductService;

public class AdminUpdateProductUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡpid
		String pid = request.getParameter("pid");
		//����ҵ���ĸ���pid��ѯ��Ʒ�ķ���
		ProductService productService = new ProductService();
		Product product = null;
		try {
			product = productService.findProductByPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Category> categoryList = null;
		try {
			categoryList = productService.addProductUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("product", product);
		
		//����ת����edit.jspҳ��
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}