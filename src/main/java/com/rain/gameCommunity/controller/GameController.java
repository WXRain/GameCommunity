package com.rain.gameCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameService gameService;

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
		List<GameEntity> games = gameService.showAllGame();
		return new JsonResult<List<GameEntity>>(games);
	}

	@RequestMapping("/showGame.do")
	@ResponseBody
	public JsonResult<GameEntity> showGame(String gameName) {
		GameEntity game = gameService.showGame(gameName);
		return new JsonResult<GameEntity>(game);
	}
}
