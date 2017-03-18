package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.GameTypeEntity;

@Repository
public interface GameTypeService {

	public List<GameTypeEntity> showAllGameTypes() throws Exception;
	
	public GameTypeEntity queryGameTypeById(long id) throws Exception;
}
