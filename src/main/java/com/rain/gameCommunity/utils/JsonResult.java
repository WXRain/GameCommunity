package com.rain.gameCommunity.utils;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

	private final static int ERROR = 1;

	private final static int SUCCESS = 0;
	
	//返回的状态
	private int state;

	//返回的消息
	private String message;

	//返回的数据
	private T data;
	
	//返回的页面信息
	private PagingData pagingData;

	public JsonResult() {

	}

	public JsonResult(int state, String message, T data, PagingData pagingData) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
		this.pagingData = pagingData;
	}

	public JsonResult(String message) {
		this(ERROR, message, null, null);
	}

//	public JsonResult(T data) {
//		this(SUCCESS, "", data, new PagingData(data));
//	}
	
	public JsonResult(T data, PagingData pagingData){
		this(SUCCESS, "", data, pagingData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	public PagingData getPagingData() {
		return pagingData;
	}

	public void setPagingData(PagingData pagingData) {
		this.pagingData = pagingData;
	}
	
	

}
