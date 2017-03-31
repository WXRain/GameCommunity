package com.rain.gameCommunity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.ShoppingCartEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.ShoppingCartService;
import com.rain.gameCommunity.utils.JsonResult;

@Controller
@RequestMapping("/pay")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/showGameShoppingCart.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> showGameShoppingCart(long userId){
		System.out.println("showGameShopping was be called" + userId);
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
		try{
			games = gameService.showGamesByIds(gameIds);
			System.out.println(games);
			return new JsonResult<List<GameEntity>>(games, null);
		}catch(Exception e){
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
	}
}
