package com.rain.gameCommunity.controller;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

	private final static int ERROR = 1;

	private final static int SUCCESS = 0;

	// 状态
	private int state;

	// 错误信息
	private String message;

	// 数据
	private T data;

	public JsonResult() {

	}

	public JsonResult(int state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public JsonResult(String message) {
		this(ERROR, message, null);
	}

	public JsonResult(T data) {
		this(SUCCESS, "", data);
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

}
