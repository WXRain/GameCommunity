package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.GameTypeEntity;
/**
 * 
 * @author wangxinyu
 *
 */
@Repository
public interface GameTypeDAO {

	public List<GameTypeEntity> queryAllGameTypes();
	
	public GameTypeEntity queryGameTypeById(@Param("id") long id);
	
	public Integer queryGameTypeCount ();
	
	public List<GameTypeEntity> queryGameTypesByPage(@Param("startLocation") int startLocation, @Param("perPageNum") int perPageNum);
	
	public void addGameType(@Param("gameType") GameTypeEntity gameType);
	
	public void updateGameType(@Param("gameType") GameTypeEntity gameType);
	
	public GameTypeEntity queryGameTypeByName(@Param("gameTypeName") String gameTypeName);
	
	public void deleteGameTypeByGameTypeId(@Param("gameTypeId") long gameTypeId);
}
