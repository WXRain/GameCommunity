package com.rain.gameCommunity.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.OrderDAO;
import com.rain.gameCommunity.entity.OrderEntity;
import com.rain.gameCommunity.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Override
	public boolean addOrder(long userId, String gameIds, Date createTime, double finalTotalPrice) throws Exception {
		OrderEntity order = new OrderEntity();
		order.setCreateTime(createTime);
		order.setGameIds(gameIds);
		order.setMoney(finalTotalPrice);
		order.setPayTime(new Date());
		order.setUserId(userId);
		System.out.println(order.getCreateTime());
		orderDao.addOrder(order);
		return true;
	}

}
