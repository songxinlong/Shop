package com.sxl.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean<E> {
	//��ǰҳ
	private Integer currentPage;
	//��ǰҳ��ʾ������
	private Integer currentCount;
	//������
	private Integer totalCount;
	//��ҳ��
	private Integer totalPage;
	//ÿҳҪ��ʾ������
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
