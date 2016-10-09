
package com.wangsong.sys.util;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class Page {


	//-- 分页参数 --//
	protected int pageNo = 1;
	protected int pageSize = -1;


	//-- 返回结果 --//
	protected  List<?> result = Lists.newArrayList();
	protected long totalCount = -1;

	
	
	public Page(int pageNo,int pageSize){
		this.pageNo=pageNo;
		this.pageSize=pageSize;

	}



	public int getPageNo() {
		return pageNo;
	}



	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	public long getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}



	public List<?> getResult() {
		return result;
	}



	public void setResult(List<?> result) {
		this.result = result;
	}



}
