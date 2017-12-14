package com.sxl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.eclipse.jdt.internal.compiler.parser.Scanner;

import com.sxl.util.DataSourceUtils;
import com.sxl.domain.*;

public class ProductDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		List<Product> productList = runner.query(sql,new BeanListHandler<Product>(Product.class));
		return productList;
		
		
	}

	public List<Product> showProductInfo(String pname,String pimage) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select pname,pimage,pid,shop_price,market_price,pdesc from product where pname=? or pimage=?";
		List<Product> productInfoList = runner.query(sql, new BeanListHandler<Product>(Product.class),pname,pimage);
		return productInfoList;
	}

	public List<Category> addProductUI() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	//添加商品
	public void addProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		int update = runner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),
				product.getPdate(),product.getIs_hot(),product.getPdesc(),
				product.getPflag(),product.getCid());
		System.out.println(update);
		
		
	}

	public void delProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid=?";
		runner.update(sql,pid);
		
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = runner.query(sql,new BeanHandler<Product>(Product.class), pid);
		return product;
	}
	
	
	//更新商品

	public void updatProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=? ";
		runner.update(sql, product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),
				product.getPdate(),product.getIs_hot(),product.getPdesc(),
				product.getPflag(),product.getCid(),product.getPid());
		
	}

	public List<Product> findProductByCondition(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where 1=1";
		List<String> params = new ArrayList<>();
		if(product.getPname()!=null&&!product.getPname().trim().equals("")){
			sql+=" and pname like ? ";
			params.add("%"+product.getPname()+"%");
		}
		if(product.getIs_hot()!=null&&!product.getIs_hot().trim().equals("")){
			sql+=" and is_hot=? ";
			params.add(product.getIs_hot());
		}
		if(product.getCid()!=null&&!product.getCid().trim().equals("")){
			sql+=" and cid=? ";
			params.add(product.getCid());
		}
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class), params.toArray());
		return productList;
	}

	//查询总条数
	public int findAllCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		Long totalCount = (Long) runner.query(sql,new ScalarHandler());
		return totalCount.intValue();
	}

	//分页查询每页要显示的商品
	public List<Product> findPageProduct(int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class),index,currentCount);
		return productList;
	}

	

}
