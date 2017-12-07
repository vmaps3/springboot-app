package com.wangsong.common.model;

public class Result {
	private String result ;
	private Object data ;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Result(String result, Object data) {
		super();
		this.result = result;
		this.data = data;
	}
	
	public Result(){};
}
