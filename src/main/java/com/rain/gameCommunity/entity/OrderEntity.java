package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author wangxinyu
 *
 */
@Repository
public class OrderEntity implements Serializable {

	//订单id
	private long id;
	
	//下单用户id
	private long userId;
	
	//订单创建时间
	private Date createTime;
	
	//订单付款时间
	private Date payTime;
	
	private String createTimeString;
	
	private String payTimeString;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//订单付款金额
	private double money;
	
	//订单中的游戏
	private String gameIds;

	public OrderEntity(long id, long userId, Date createTime, Date payTime, String createTimeString,
			String payTimeString, SimpleDateFormat sdf, double money, String gameIds) {
		super();
		this.id = id;
		this.userId = userId;
		this.createTime = createTime;
		this.payTime = payTime;
		this.createTimeString = createTimeString;
		this.payTimeString = payTimeString;
		this.sdf = sdf;
		this.money = money;
		this.gameIds = gameIds;
	}

	public OrderEntity() {
		
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", userId=" + userId + ", createTime=" + createTime + ", payTime=" + payTime
				+ ", createTimeString=" + createTimeString + ", payTimeString=" + payTimeString + ", sdf=" + sdf
				+ ", money=" + money + ", gameIds=" + gameIds + "]";
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getCreateTimeString() {
		return createTimeString;
	}

	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
	}

	public String getPayTimeString() {
		return payTimeString;
	}

	public void setPayTimeString(String payTimeString) {
		this.payTimeString = payTimeString;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getGameIds() {
		return gameIds;
	}

	public void setGameIds(String gameIds) {
		this.gameIds = gameIds;
	}
	
	
}
