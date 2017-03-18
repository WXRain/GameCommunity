package com.rain.gameCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameTypeDAO;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.service.GameTypeService;

@Service
public class GameTypeServiceImpl implements GameTypeService {

	@Autowired
	private GameTypeDAO gameTypeDao;
	
	@Override
	public List<GameTypeEntity> showAllGameTypes() throws Exception{
		List<GameTypeEntity> types = gameTypeDao.queryAllGameTypes();
		for(GameTypeEntity type : types){
			type.setCreateTimeString(type.getSdf().format(type.getCreateTime()));
		}
		return types;
	}

	@Override
	public GameTypeEntity queryGameTypeById(long id) throws Exception {
		GameTypeEntity type = gameTypeDao.queryGameTypeById(id);
		type.setCreateTimeString(type.getSdf().format(type.getCreateTime()));
		return type;
	}

}
