package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.utils.PagingData;
/**
 * 
 * @author wangxinyu
 *
 */
@Component
public interface GameTypeService {

	public List<GameTypeEntity> showAllGameTypes() throws Exception;
	
	public GameTypeEntity queryGameTypeById(long id) throws Exception;
	
	public int queryGameTypeCount() throws Exception;
	
	public List<GameTypeEntity> showGameTypesByPage(PagingData pagingData) throws Exception;
	
	public void updateGameType(GameTypeEntity gameType) throws Exception;
	
	public void addGameType(GameTypeEntity gameType) throws Exception;
	
	public GameTypeEntity queryGameTypeByName(String gameTypeName) throws Exception;
}
