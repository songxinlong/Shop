package com.sxl.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.sxl.domain.PageBean;
import com.sxl.domain.Product;
import com.sxl.service.ProductService;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页\
		
		String Pagestr = request.getParameter("curentPage");
		if(Pagestr==null) Pagestr="1";
		int currentPage = Integer.parseInt(Pagestr);
		
		//每页显示的条数
		int currentCount=12;
		
		ProductService productService = new ProductService();
		PageBean pageBean = null;
		try {
			pageBean = productService.findPageProduct(currentPage,currentCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}