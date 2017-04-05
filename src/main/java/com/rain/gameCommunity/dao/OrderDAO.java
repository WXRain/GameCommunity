package com.rain.gameCommunity.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.OrderEntity;

@Repository
public interface OrderDAO {

	public void addOrder(@Param("order") OrderEntity order);
}
