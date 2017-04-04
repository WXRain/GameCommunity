package com.rain.gameCommunity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.service.SectionService;
import com.rain.gameCommunity.service.ShoppingCartService;
import com.rain.gameCommunity.service.UserService;
import com.rain.gameCommunity.utils.JsonResult;
import com.rain.gameCommunity.utils.PagingData;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameTypeService gameTypeService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	private String gameName;
	

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName
	 *            the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

//	@RequestMapping("/showallgame.do")
//	@ResponseBody
//	public JsonResult<List<GameEntity>> showAllGame() {
//		List<GameEntity> games;
//		try {
//			games = gameService.showAllGame();
//		} catch (Exception e) {
//			return new JsonResult<List<GameEntity>>(e.getMessage());
//		}
//		return new JsonResult<List<GameEntity>>(games);
//	}

	@RequestMapping("/showGame.do")
	@ResponseBody
	public JsonResult<GameEntity> showGame(String gameId) {
		GameEntity game;
		try {
			game = gameService.showGameById(gameId);
		} catch (Exception e) {
			return new JsonResult<GameEntity>(e.getMessage());
		}
		
		return new JsonResult<GameEntity>(game, null);
	}
	
	@RequestMapping("/showAllGameType.do")
	@ResponseBody
	public JsonResult<List<GameTypeEntity>> showAllGameType(int currentPage){
		List<GameTypeEntity> gameTypes;
		PagingData pagingData = new PagingData();
		if(currentPage == 0) currentPage = 1;
		try{
			pagingData.setCurrentPage(currentPage);
			pagingData.setTotalNum(gameTypeService.queryGameTypeCount());
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			
			gameTypes = gameTypeService.showGameTypesByPage(pagingData);
		}catch(Exception e){
			return new JsonResult<List<GameTypeEntity>>(e.getMessage());
		}
		return new JsonResult<List<GameTypeEntity>>(gameTypes, pagingData);
	}
	
	@RequestMapping("/showGameByGameType.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> showGameByGameType(long gameType, int currentPage){
		PagingData pagingData = new PagingData();
		try{
			pagingData.setTotalNum(gameService.showGamesCountByGameType(gameType));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<GameEntity> games = gameService.showGamesByGameType(gameType, pagingData);
			return new JsonResult<List<GameEntity>>(games, pagingData);
		}catch(Exception e){
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/getSectionByGameId.do")
	@ResponseBody
	public JsonResult<SectionEntity> getSectionByGameId(long gameId){
		System.out.println("gameId:" + gameId);
		try{
			List<SectionEntity> sections = sectionService.showSectionByGameId(gameId);
			if(sections == null || sections.size() <= 0)
				return new JsonResult<SectionEntity>(null, null);
			SectionEntity section = sections.get(0);
			return new JsonResult<SectionEntity>(section, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<SectionEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/addToShoppingCart.do")
	@ResponseBody
	public JsonResult<Boolean> addToShoppingCart(long gameId, long userId){
		try{
			//检查游戏是否已经购买
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			if(users == null || users.size() <= 0){
				throw new Exception("没有找到用户！");
			}
			UserEntity user = users.get(0);
			
			System.out.println("取得的用户为：" + user);
			String[] games = user.getGames().split(",");
			
			for(int i = 0; i < games.length; i++){
				if(games[i].length() <= 0 || games[i].equals("")) continue;
				if(games[i].equals(gameId + "")){
					return new JsonResult<Boolean>(false, null);
				}
			}
			
			shoppingCartService.addToShoppingCart(userId, gameId);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addShoppingCartOrDownload.do")
	@ResponseBody
	public JsonResult<Boolean> addShoppingCartOrDownload(long userId, long gameId){
		System.out.println("-------------------------------------");
		System.out.println("判断当前用户是否已经购买该游戏");
		try{
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			if(users == null || users.size() <= 0){
				throw new Exception("没有找到用户！");
			}
			UserEntity user = users.get(0);
			
			System.out.println("取得的用户为：" + user);
			String[] games = user.getGames().split(",");
			
			for(int i = 0; i < games.length; i++){
				if(games[i].length() <= 0 || games[i].equals("")) continue;
				if(games[i].equals(gameId + "")){
					return new JsonResult<Boolean>(true, null);
				}
			}
			
			return new JsonResult<Boolean>(false, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addDownloadNum.do")
	@ResponseBody
	public JsonResult<Boolean> addDownloadNum(long gameId){
		try{
			GameEntity game = gameService.showGameById(gameId + "");
			System.out.println(game);
			game.setDownloadNum(game.getDownloadNum() + 1);
			gameService.updateGameEntity(game);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/showGameType.do")
	@ResponseBody
	public JsonResult<GameTypeEntity> showGameType(String gameTypeId){
		try{
			System.out.println(gameTypeId);
			GameTypeEntity gameTypeEntity = gameTypeService.queryGameTypeById(Long.parseLong(gameTypeId));
			return new JsonResult<GameTypeEntity>(gameTypeEntity, null);
		}catch(Exception e){
			return new JsonResult<GameTypeEntity>(e.getMessage());
		}
	}
}
