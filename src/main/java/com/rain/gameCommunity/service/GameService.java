package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.GameEntity;

@Repository
public interface GameService {

	public List<GameEntity> showAllGame() throws Exception;

	public GameEntity showGame(String gameName) throws Exception;
}