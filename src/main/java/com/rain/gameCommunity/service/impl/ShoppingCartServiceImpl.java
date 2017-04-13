package com.rain.gameCommunity.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.ShoppingCartDAO;
import com.rain.gameCommunity.entity.ShoppingCartEntity;
import com.rain.gameCommunity.service.ShoppingCartService;
/**
 * 
 * @author wangxinyu
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartDAO shoppingCartDao;
	
	@Override
	public List<ShoppingCartEntity> showShoppingCartByUserId(long userId) throws Exception{
		return shoppingCartDao.queryShoppingCartByUserId(userId);
	}

	@Override
	public void updateShoppingCartRemove(long userId, String gameIds) throws Exception{
		List<ShoppingCartEntity> shoppingCarts = showShoppingCartByUserId(userId);
		ShoppingCartEntity shoppingCart = new ShoppingCartEntity();
		if(shoppingCarts != null && shoppingCarts.size() > 0)
			shoppingCart = shoppingCarts.get(0);
		else return;
		//取出原来的购物车游戏信息
		String[] beforeGameIds = shoppingCart.getGameIds().split(",");
		String[] nowGameIds = gameIds.split(",");
		
		//删除游戏
		for(int i = 0; i < beforeGameIds.length; i++){
			for(int j = 0; j < nowGameIds.length; j++){
				if(beforeGameIds[i].equals(nowGameIds[j])){
					beforeGameIds[i] = "";
				}
			}
		}
		String nowGame = "";
		for(int i = 0; i < beforeGameIds.length; i++){
			if(!beforeGameIds[i].equals("")){
				nowGame = nowGame + beforeGameIds[i] + ",";
			}
		}
		
		if(nowGame.equals("") || nowGame.length() == 0){
			shoppingCartDao.deleteShoppingCartByUserId(userId);
			return ;
		}
		
		else nowGame = nowGame.substring(0, nowGame.length() - 1);
		
		shoppingCartDao.updateShoppingCartGameIds(userId, nowGame);
	}

	@Override
	public void addToShoppingCart(long userId, long gameId) throws Exception {
		
		//取出原来的购物车信息
		List<ShoppingCartEntity> shoppingCarts = shoppingCartDao.queryShoppingCartByUserId(userId);
		ShoppingCartEntity shoppingCart = new ShoppingCartEntity();
		String gameIds = "";
		if(shoppingCarts!=null && shoppingCarts.size() > 0 ) {
			shoppingCart = shoppingCarts.get(0);
			gameIds = shoppingCart.getGameIds();
			gameIds = gameIds + "," + gameId;
			//更新购物车信息
			shoppingCartDao.updateShoppingCartGameIds(userId, gameIds);
			return;
		}else{
			gameIds = gameIds + gameId;
			shoppingCart.setUserId(userId);
			shoppingCart.setGameIds(gameIds);
			shoppingCart.setCreateTime(new Date());
			//增加购物车信息
			shoppingCartDao.addShoppingCart(shoppingCart);
		}
		
		
	}

}
