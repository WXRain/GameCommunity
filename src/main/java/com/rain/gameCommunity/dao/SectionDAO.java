package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.SectionEntity;

@Repository
public interface SectionDAO {

	public List<SectionEntity> queryAllSections();
	
	public List<SectionEntity> querySectionsByGameTypeId(@Param("id") long id);
	
	public List<SectionEntity> querySectionsBySectionId(@Param("id") List<Long> id);
	
	public Integer querySectionsCountByGameTypeId(@Param("id") long id);
	
	//根据游戏id取得板块信息
	public List<SectionEntity> querySectionByGameId(@Param("gameId") long gameId);
	
	public long addSection(@Param("section") SectionEntity section);
}
