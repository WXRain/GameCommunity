package com.rain.gameCommunity.service;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderService {

	//增加订单
	public boolean addOrder(long userId, String gameIds, Date createTime, double finalTotalPrice) throws Exception;
}
