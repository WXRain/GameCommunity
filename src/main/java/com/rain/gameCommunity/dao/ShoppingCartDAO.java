package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.ShoppingCartEntity;

@Repository
public interface ShoppingCartDAO {

	//通过用户id查找购物车
	public List<ShoppingCartEntity> queryShoppingCartByUserId(@Param("userId") long userId);
	
	//更新购物车数据
	public void updateShoppingCartGameIds(@Param("userId") long userId, @Param("gameIds") String gameIds);
	
	//删除购物车数据
	public void deleteShoppingCartByUserId(@Param("userId") long userId);
	
	//添加购物车数据
	public void addShoppingCart(@Param("shoppingCart") ShoppingCartEntity shoppingCart);
	
}
