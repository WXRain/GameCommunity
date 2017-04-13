package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameDAO;
import com.rain.gameCommunity.dao.SectionDAO;
import com.rain.gameCommunity.dao.TopicDAO;
import com.rain.gameCommunity.dao.UserDAO;
import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.utils.PagingData;
/**
 * 
 * @author wangxinyu
 *
 */
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDao;
	
	@Autowired
	private SectionDAO sectionDao;
	
	@Autowired
	private TopicDAO topicDao;
	
	@Autowired
	private UserDAO userDao;

	public List<GameEntity> showAllGame() throws Exception {

		List<GameEntity> games = new ArrayList<GameEntity>();
		games = gameDao.queryAllGame();
		return games;
	}
	
	private List<TopicEntity> changeUserIdToString(List<TopicEntity> topics) throws Exception{
		if(topics == null || topics.size() <= 0) return null;
		for(TopicEntity topic : topics){
			long userId = topic.getUserId();
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userDao.queryUsersById(ids);
			for(UserEntity user : users){
				topic.setUsername(user.getUsername());
			}
		}
		return topics;
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
		//取出section
		List<SectionEntity> sections = sectionDao.querySectionByGameId(idLong);
		
		if(sections == null || sections.size() <= 0) return game;
		
		SectionEntity section = sections.get(0);
		long sectionId = section.getId();
		
		game.setComments(changeUserIdToString(topicDao.queryCommentsBySectionId(sectionId)));
		
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

	@Override
	public long addGame(GameEntity game) throws Exception {
		return gameDao.addGame(game);
	}

	@Override
	public void deleteGameByGameId(long gameId) throws Exception {
		gameDao.deleteGameByGameId(gameId);
		
	}

	@Override
	public List<GameEntity> showGameByGameType(long gameType) throws Exception {
		return gameDao.queryGamesByGameType(gameType);
	}

}
