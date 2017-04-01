package com.rain.gameCommunity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.ShoppingCartEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.OrderService;
import com.rain.gameCommunity.service.ShoppingCartService;
import com.rain.gameCommunity.service.UserService;
import com.rain.gameCommunity.utils.JsonResult;

@Controller
@RequestMapping("/pay")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/showGameShoppingCart.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> showGameShoppingCart(long userId){
		System.out.println("showGameShopping was be called" + userId);
		try{
			List<ShoppingCartEntity> shoppingCarts = shoppingCartService.showShoppingCartByUserId(userId);
			ShoppingCartEntity shoppingCart = new ShoppingCartEntity();
			
			if(shoppingCarts.size() > 0) shoppingCart = shoppingCarts.get(0);
			else return new JsonResult<List<GameEntity>>(null, null);
			
			String shoppingCartGames = shoppingCart.getGameIds();
			System.out.println(shoppingCartGames);
			String[] gameIdsString = shoppingCartGames.split(",");
			List<Long> gameIds = new ArrayList<Long>();
			for(int i = 0; i < gameIdsString.length; i++){
				if(gameIdsString[i] == null || gameIdsString[i] == "") continue;
				gameIds.add(Long.parseLong(gameIdsString[i]));
			}
			List<GameEntity> games;
			games = gameService.showGamesByIds(gameIds);
			System.out.println(games);
			return new JsonResult<List<GameEntity>>(games, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/doSuccess.do")
	@ResponseBody
	@Transactional
	public JsonResult<Boolean> doSuccess(long userId, String gameIds, Date createTime, double finalTotalPrice){
		try{
			System.out.println("userId:" + userId + " gameIds:" + gameIds + " createTime:" + createTime + " finalTotalPrice:" + finalTotalPrice);
			
			//向订单中增加付款的订单信息
			orderService.addOrder(userId, gameIds, createTime, finalTotalPrice);
			System.out.println("增加订单信息成功");
			
			//更新数据库中购物车的信息
			shoppingCartService.updateShoppingCartRemove(userId, gameIds);
			System.out.println("更新数据库购物车信息成功");
			
			//更新账户中已经购买的游戏的信息	
			userService.updateUserGames(userId, gameIds);
			System.out.println("更新账户信息成功");
			
			return new JsonResult<Boolean>(true, null);
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/removeFromShoppingCart.do")
	@ResponseBody
	public JsonResult<Boolean> removeFromShoppingCart(long userId, long gameId){
		try{
			System.out.println("removeFromShoppingCart: userId:" + userId + " gameId:" + gameId);
			shoppingCartService.updateShoppingCartRemove(userId, gameId + "");
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
}
