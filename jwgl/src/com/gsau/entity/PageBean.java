package com.gsau.entity;

import java.util.List;

//��ҳ����
public class PageBean<T> {
	//��ǰҳ
	private int currPage;
//	ÿҳ��ʾ�ļ�¼��
	private int pageSize;
//	�ܵļ�¼��
	private int totalCount;
//	�ܵ�ҳ��
	private int totalPage;
	private List<T> list;
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
