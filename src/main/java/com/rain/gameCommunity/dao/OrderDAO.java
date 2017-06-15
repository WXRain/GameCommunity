package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.OrderEntity;
/**
 * 
 * @author wangxinyu
 *
 */
@Repository
public interface OrderDAO {

	public void addOrder(@Param("order") OrderEntity order);
	
	public List<OrderEntity> findOrdersByUserId(@Param("userId") long userId);
}
