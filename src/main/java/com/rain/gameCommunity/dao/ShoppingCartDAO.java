package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rain.gameCommunity.entity.ShoppingCartEntity;

public interface ShoppingCartDAO {

	//通过用户id查找购物车
	public List<ShoppingCartEntity> queryShoppingCartByUserId(@Param("userId") long userId);
}
