/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wangsong.sys.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * 与具体ORM实现无关的分页参数及查询结果封装.
 * 
 * 注意所有序号从1开始.
 * 
 * @param  Page中记录的类型.
 * 
 * @author calvin
 */
public class Page {


	//-- 分页参数 --//
	protected int pageNo = 1;
	protected int pageSize = -1;
	

	//-- 返回结果 --//
	protected List result = Lists.newArrayList();
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



	public List getResult() {
		return result;
	}



	public void setResult(List result) {
		this.result = result;
	}



	public long getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	
	
}
