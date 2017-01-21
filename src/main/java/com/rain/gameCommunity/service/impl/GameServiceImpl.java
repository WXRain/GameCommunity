package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameDAO;
import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO dao;

	public List<GameEntity> showAllGame() {

		List<GameEntity> games = new ArrayList<GameEntity>();
		games = dao.queryAllGame();
		return games;
	}

	@Override
	public GameEntity showGame(String gameName) {
		GameEntity game = new GameEntity();
		game = dao.queryGameByName(gameName);
		return game;
	}

}
