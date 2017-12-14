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
	
	//��ѯ��Ʒ����

	public List<Category> addProductUI() throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Category> categoeryLIst = productDao.addProductUI();
		return categoeryLIst;
	}

	//�����Ʒ
	public void addProduct(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.addProduct(product);
		
	}
	
	//����pidɾ����Ʒ������ɾ����

	public void delProductByPid(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.delProductByPid(pid);
	}
	
	//����pid��ѯ��Ʒ

	public Product findProductByPid(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.findProductByPid(pid);
		
	}
	
	
	//������Ʒ

	public void updatProduct(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.updatProduct(product);
		
	}
	
	//����������ѯ��Ʒ

	public List<Product> findProductByCondition(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.findProductByCondition(product);
	}
	
	
	//��ҳ��ѯ
	public PageBean findPageProduct(int currentPage, int currentCount) throws Exception {
		PageBean pageBean = new PageBean();
		ProductDao productDao = new ProductDao();
//		//��ǰҳ
//		private Integer currentPage;
		pageBean.setCurrentPage(currentPage);
		
//		//��ǰҳ��ʾ������
//		private Integer currentCount;
		pageBean.setCurrentCount(currentCount);
		
//		//������
//		private Integer totalCount;
		int totalCount = productDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		
//		//��ҳ��
//		private Integer totalPage;
		Integer totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//ÿҳҪ��ʾ������
//		private List<E> pageList = new ArrayList<E>();
		int index = (currentPage-1)*currentCount;
		List<Product> productList = productDao.findPageProduct(index,currentCount);
		pageBean.setPageList(productList);
		
		return pageBean;
	}

}
