package com.rain.gameCommunity.dao;

import org.apache.ibatis.annotations.Param;

import com.rain.gameCommunity.entity.OrderEntity;

public interface OrderDAO {

	public void addOrder(@Param("order") OrderEntity order);
}
