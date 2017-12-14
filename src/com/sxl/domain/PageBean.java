package com.sxl.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean<E> {
	//当前页
	private Integer currentPage;
	//当前页显示的条数
	private Integer currentCount;
	//总条数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//每页要显示的内容
	private List<E> pageList = new ArrayList<E>();
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<E> getPageList() {
		return pageList;
	}
	public void setPageList(List<E> pageList) {
		this.pageList = pageList;
	}
	
	
	

}
