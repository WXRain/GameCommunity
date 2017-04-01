package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.ShoppingCartEntity;

@Repository
public interface ShoppingCartService {

	//通过用户id查找购物车信息
	public List<ShoppingCartEntity> showShoppingCartByUserId(long userId) throws Exception;
	
	//更新购物车信息:	删除
	public void updateShoppingCartRemove(long userId, String gameIds) throws Exception;
	
	//增加购物车信息
	public void addToShoppingCart(long userId, long gameId) throws Exception;
}
