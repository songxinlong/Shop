package com.sxl.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sxl.domain.Product;
import com.sxl.service.ProductService;

public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UtF-8");
		//获取参数
		Map<String, String[]> productMap = request.getParameterMap();
		//封装成javaBean
		Product product = new Product();
		//手动添加未赋值的属性
				//1)、private String pid;
				
				product.setPid(UUID.randomUUID().toString());
				
				
				//2)、private String pimage;
				
				product.setPimage("products/1/c_0001.jpg");
				
				//3)、private String pdate;
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				String pdate = formate.format(new Date());
				System.out.println(pdate);
				product.setPdate(pdate);
				
				//4)、private Integer pflag;
				product.setPflag(0);//0表示未下架
		
		
		try {
			BeanUtils.populate(product, productMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-------------到此为止参数已经封装完成
		
		
		//调用service层的业务方法
		ProductService productService = new ProductService();
		try {
			productService.addProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		
		response.sendRedirect(request.getContextPath()+"/AdminProductList");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}