package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameTypeDAO;
import com.rain.gameCommunity.dao.UserDAO;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.utils.PagingData;

@Service
public class GameTypeServiceImpl implements GameTypeService {

	@Autowired
	private GameTypeDAO gameTypeDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public List<GameTypeEntity> showAllGameTypes() throws Exception{
		List<GameTypeEntity> types = gameTypeDao.queryAllGameTypes();
		if(types != null && types.size() > 0){
			types = changeManagerToString(types);
			for(GameTypeEntity type : types){
				type.setCreateTimeString(type.getSdf().format(type.getCreateTime()));
			}
		}
		return types;
	}

	@Override
	public GameTypeEntity queryGameTypeById(long id) throws Exception {
		GameTypeEntity type = gameTypeDao.queryGameTypeById(id);
		if(type != null){
			List<GameTypeEntity> types = new ArrayList<GameTypeEntity>();
			types.add(type);
			type = changeManagerToString(types).get(0);
			type.setCreateTimeString(type.getSdf().format(type.getCreateTime()));
		}
		
		return type;
	}

	private List<GameTypeEntity> changeManagerToString(List<GameTypeEntity> gameTypes) throws Exception{
		if(gameTypes == null || gameTypes.size() <= 0) return null;
		for(GameTypeEntity gameType : gameTypes){
			String gameTypeManager = gameType.getManager();
			if(gameTypeManager == null || gameTypeManager.length() <= 0) continue;
			String[] managersString = gameTypeManager.split(",");
			List<Long> managers = new ArrayList<Long>();
			for(int i = 0; i < managersString.length; i++){
				managers.add(Long.parseLong(managersString[i]));
			}
			List<UserEntity> users = userDao.queryUsersById(managers);
			gameType.setManagers(users);
		}
		return gameTypes;
	}
	
	private GameTypeEntity changeManagerToString(GameTypeEntity gameType) throws Exception{
		if (gameType == null) return null;
		String gameTypeManager = gameType.getManager();
		if(gameTypeManager == null || gameTypeManager.length() <= 0) return gameType;
		String[] managersString = gameTypeManager.split(",");
		List<Long> managers = new ArrayList<Long>();
		for(int i = 0; i < managersString.length; i++){
			managers.add(Long.parseLong(managersString[i]));
		}
		List<UserEntity> users = userDao.queryUsersById(managers);
		gameType.setManagers(users);
		return gameType;
	}

	@Override
	public int queryGameTypeCount() throws Exception {
		return gameTypeDao.queryGameTypeCount();
	}

	@Override
	public List<GameTypeEntity> showGameTypesByPage(PagingData pagingData) throws Exception {
		List<GameTypeEntity> types = changeManagerToString(gameTypeDao.queryGameTypesByPage((pagingData.getCurrentPage()-1)*pagingData.getPerPageNum(),
												pagingData.getPerPageNum())); 
		for(GameTypeEntity type : types){
			type.setCreateTimeString(type.getSdf().format(type.getCreateTime()));
		}
		return types;
	}

	@Override
	public void updateGameType(GameTypeEntity gameType) throws Exception {
		
		gameTypeDao.updateGameType(gameType);
	}

	@Override
	public void addGameType(GameTypeEntity gameType) throws Exception {
		
		gameTypeDao.addGameType(gameType);
	}

	@Override
	public GameTypeEntity queryGameTypeByName(String gameTypeName) throws Exception {
		return changeManagerToString(gameTypeDao.queryGameTypeByName(gameTypeName));
	}
	
}
