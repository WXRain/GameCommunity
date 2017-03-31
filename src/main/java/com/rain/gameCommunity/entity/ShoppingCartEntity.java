package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShoppingCartEntity implements Serializable {

	//购物车id
	private long id;
	
	//用户id
	private long userId;
	
	//购物车中的游戏
	private String gameIds;
	
	//创建时间
	private Date createTime;
	
	private String createTimeString;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public ShoppingCartEntity(long id, long userId, String gameIds, Date createTime, String createTimeString,
			SimpleDateFormat sdf) {
		super();
		this.id = id;
		this.userId = userId;
		this.gameIds = gameIds;
		this.createTime = createTime;
		this.createTimeString = createTimeString;
		this.sdf = sdf;
	}

	public ShoppingCartEntity() {
		
	}

	@Override
	public String toString() {
		return "ShoppingCartEntity [id=" + id + ", userId=" + userId + ", gameIds=" + gameIds + ", createTime="
				+ createTime + ", createTimeString=" + createTimeString + ", sdf=" + sdf + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getGameIds() {
		return gameIds;
	}

	public void setGameIds(String gameIds) {
		this.gameIds = gameIds;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeString() {
		return createTimeString;
	}

	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	
	
}
