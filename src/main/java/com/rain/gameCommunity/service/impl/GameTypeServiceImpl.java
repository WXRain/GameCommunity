package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameTypeDAO;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.GameTypeService;

@Service
public class GameTypeServiceImpl implements GameTypeService {

	@Autowired
	private GameTypeDAO gameTypeDao;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
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
		
		for(GameTypeEntity gameType : gameTypes){
			String gameTypeManager = gameType.getManager();
			String[] managersString = gameTypeManager.split(",");
			List<Long> managers = new ArrayList<Long>();
			for(int i = 0; i < managersString.length; i++){
				managers.add(Long.parseLong(managersString[i]));
			}
			List<UserEntity> users = userServiceImpl.queryUsersById(managers);
			gameType.setManagers(users);
		}
		return gameTypes;
	}
	
}
