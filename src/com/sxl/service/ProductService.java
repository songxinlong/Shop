package com.sxl.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.beans.editors.IntegerEditor;
import com.sxl.dao.ProductDao;
import com.sxl.domain.Category;
import com.sxl.domain.PageBean;
import com.sxl.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> productList = productDao.findAllProduct();
		return productList;
	}

	public List<Product> showProductInfo(String pname,String pimage) throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> productInfoList = productDao.showProductInfo(pname,pimage);
		
		return productInfoList;
		// TODO Auto-generated method stub
		
	}
	
	//查询商品种类

	public List<Category> addProductUI() throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Category> categoeryLIst = productDao.addProductUI();
		return categoeryLIst;
	}

	//添加商品
	public void addProduct(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.addProduct(product);
		
	}
	
	//根据pid删除商品（物理删除）

	public void delProductByPid(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.delProductByPid(pid);
	}
	
	//根据pid查询商品

	public Product findProductByPid(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.findProductByPid(pid);
		
	}
	
	
	//更新商品

	public void updatProduct(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.updatProduct(product);
		
	}
	
	//根据条件查询商品

	public List<Product> findProductByCondition(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.findProductByCondition(product);
	}
	
	
	//分页查询
	public PageBean findPageProduct(int currentPage, int currentCount) throws Exception {
		PageBean pageBean = new PageBean();
		ProductDao productDao = new ProductDao();
//		//当前页
//		private Integer currentPage;
		pageBean.setCurrentPage(currentPage);
		
//		//当前页显示的条数
//		private Integer currentCount;
		pageBean.setCurrentCount(currentCount);
		
//		//总条数
//		private Integer totalCount;
		int totalCount = productDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		
//		//总页数
//		private Integer totalPage;
		Integer totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//每页要显示的内容
//		private List<E> pageList = new ArrayList<E>();
		int index = (currentPage-1)*currentCount;
		List<Product> productList = productDao.findPageProduct(index,currentCount);
		pageBean.setPageList(productList);
		
		return pageBean;
	}

}
