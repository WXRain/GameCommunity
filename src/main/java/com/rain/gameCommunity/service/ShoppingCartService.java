package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.ShoppingCartEntity;

@Repository
public interface ShoppingCartService {

	//通过用户id查找购物车信息
	public List<ShoppingCartEntity> showShoppingCartByUserId(long userId);
}
