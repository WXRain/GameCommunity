package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameDAO;
import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.utils.PagingData;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDao;

	public List<GameEntity> showAllGame() throws Exception {

		List<GameEntity> games = new ArrayList<GameEntity>();
		games = gameDao.queryAllGame();
		return games;
	}

	@Override
	public GameEntity showGame(String gameName) throws Exception {
		GameEntity game = new GameEntity();
		game = gameDao.queryGameByName(gameName);
		return game;
	}

	@Override
	public GameEntity showGameById(String id) throws Exception {
		long idLong = Long.parseLong(id);
		GameEntity game = gameDao.queryGameById(idLong);
		return game;
	}

	@Override
	public List<GameEntity> showGamesByGameType(long gameType, PagingData pagingData) throws Exception {
		List<GameEntity> games = gameDao.queryGameByGameType(gameType, (pagingData.getTotalPage() -1) * pagingData.getPerPageNum(),
								pagingData.getPerPageNum());
		return games;
	}

	@Override
	public Integer queryGameCountByNameCondition(String nameCondition) throws Exception {
		return gameDao.queryGameCountByNameCondition(nameCondition);
	}

	@Override
	public int showGamesCountByGameType(long gameType) throws Exception {
		return gameDao.queryGamesCountByGameType(gameType);
	}

	@Override
	public List<GameEntity> showGameByCondition(String nameCondition, PagingData pagingData) throws Exception {
		return gameDao.queryGameByCondition(nameCondition, (pagingData.getTotalPage() -1) * pagingData.getPerPageNum(),
				pagingData.getPerPageNum());
	}

	@Override
	public int showGameCountByCondition(String nameCondition) throws Exception {
		return gameDao.queryGameCountByNameCondition(nameCondition);
	}

}
