package com.rain.gameCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.utils.JsonResult;
import com.rain.gameCommunity.utils.PagingData;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameTypeService gameTypeService;

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

	@RequestMapping("/showallgame.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> showAllGame() {
		List<GameEntity> games;
		try {
			games = gameService.showAllGame();
		} catch (Exception e) {
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
		return new JsonResult<List<GameEntity>>(games);
	}

	@RequestMapping("/showGame.do")
	@ResponseBody
	public JsonResult<GameEntity> showGame(String gameId) {
		GameEntity game;
		try {
			game = gameService.showGameById(gameId);
		} catch (Exception e) {
			return new JsonResult<GameEntity>(e.getMessage());
		}
		
		return new JsonResult<GameEntity>(game);
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
	
//	@RequestMapping("/showGameTypeByPage")
//	@ResponseBody
//	public JsonResult<List<GameTypeEntity>> showGameTypeByPage(int currentPage){
//		PagingData pagingData = new PagingData();
//		try{
//			pagingData.setCurrentPage(currentPage);
//			pagingData.setTotalNum(gameType);
//			return gameTypeService.showGameTypesByPage(pagingData);
//		}catch(Exception e){
//			return new JsonResult<List<GameTypeEntity>>(e.getMessage());
//		}
//		
//	}
	
	@RequestMapping("/showGameByGameType.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> showGameByGameType(String gameType){
		try{
			List<GameEntity> games = gameService.showGamesByGameType(gameType);
			return new JsonResult<List<GameEntity>>(games);
		}catch(Exception e){
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
	}
	
}
