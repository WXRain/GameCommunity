package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameDAO;
import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.UserEntity;
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

	@Override
	public UserEntity showUserGameByUser(UserEntity user) throws Exception {
		String[] gameIdsString = user.getGames().split(",");
		List<Long> ids = new ArrayList<Long>();
		System.out.println(gameIdsString.length);
		for(int i = 0; i < gameIdsString.length; i++){
			if(gameIdsString[i] == "") continue;
			ids.add(Long.parseLong(gameIdsString[i]));
		}
		if(ids.size() == 0) return user;
		List<GameEntity> games = gameDao.queryGamesByIds(ids);
		user.setHasBuyedGames(games);
		String gameString = "";
		for(GameEntity game : games){
			gameString = gameString + game.getGameName() + ",";
		}
		gameString = gameString.substring(0, gameString.length() - 1);
		user.setGames(gameString);
		return user;
	}

	@Override
	public List<GameEntity> showGamesByIds(List<Long> ids) throws Exception {
		return gameDao.queryGamesByIds(ids);
	}

	@Override
	public void updateGameEntity(GameEntity game) throws Exception {
		
		gameDao.updateGameEntity(game);
	}

}
