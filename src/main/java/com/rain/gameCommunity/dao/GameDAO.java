package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rain.gameCommunity.entity.GameEntity;

public interface GameDAO {

	public List<GameEntity> queryAllGame();

	public GameEntity queryGameByName(@Param("gameName") String gameName);

	public GameEntity queryGameById(@Param("id") long id);
	
	public List<GameEntity> queryGameByGameType(@Param("gameType") long gameType, @Param("startLocation") int startLocation,
								@Param("perPageNum") int perPageNum);
	
	public Integer queryGameCountByNameCondition(@Param("nameCondition") String nameCondition);
	
	public int queryGamesCountByGameType(@Param("gameType") long gameType);
	
	public List<GameEntity> queryGameByCondition(@Param("nameCondition") String nameCondition, @Param("startLocation") int startLocation,
							@Param("perPageNum") int perPageNum);
	
	public List<GameEntity> queryGamesByIds(@Param("ids") List<Long> ids);
	
	public void updateGameEntity(@Param("game") GameEntity game);

}
