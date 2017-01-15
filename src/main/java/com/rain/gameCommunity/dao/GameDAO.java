package com.rain.gameCommunity.dao;

import java.util.List;

import com.rain.gameCommunity.entity.GameEntity;

public interface GameDAO {

	public List<GameEntity> queryAllGame();
}
