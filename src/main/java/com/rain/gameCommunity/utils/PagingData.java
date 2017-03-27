package com.rain.gameCommunity.utils;

import java.io.Serializable;
import java.util.List;

public class PagingData implements Serializable{

	//当前页面
	public int currentPage = 1;

	//全部页面
	public int totalPage = 1;
	
	//全部数据量
	public int totalNum = 0;
	
	//每页数量
	public int perPageNum = 1;
	
	@Override
	public String toString() {
		return "PagingData [currentPage=" + currentPage + ", totalPage=" + totalPage + ", totalNum=" + totalNum
				+ ", perPageNum=" + perPageNum + "]";
	}
	

	public PagingData(int currentPage, int totalPage, int totalNum, int perPageNum) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalNum = totalNum;
		this.perPageNum = perPageNum;
	}

	public <T> PagingData(List<T> data){
		this.totalNum = data.size();
		this.totalPage = this.totalNum/this.perPageNum + 1;
	}
	
	public <T> PagingData(T data){
		this.totalNum = 1;
	}

	public PagingData() {
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}


	public int getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	
}
