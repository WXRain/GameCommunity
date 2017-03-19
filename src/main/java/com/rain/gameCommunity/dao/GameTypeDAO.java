package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rain.gameCommunity.entity.GameTypeEntity;

public interface GameTypeDAO {

	public List<GameTypeEntity> queryAllGameTypes();
	
	public GameTypeEntity queryGameTypeById(@Param("id") long id);
}