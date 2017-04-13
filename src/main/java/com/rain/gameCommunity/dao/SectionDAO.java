package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.utils.PagingData;

@Repository
public interface SectionDAO {

	public List<SectionEntity> queryAllSections();
	
	public List<SectionEntity> querySectionsByGameTypeId(@Param("id") long id, @Param("startLocation") int startLocation,
												@Param("perPageNum") int perPageNum);
	
	public List<SectionEntity> querySectionsBySectionId(@Param("id") List<Long> id);
	
	public Integer querySectionsCountByGameTypeId(@Param("id") long id);
	
	//根据游戏id取得板块信息
	public List<SectionEntity> querySectionByGameId(@Param("gameId") long gameId);
	
	public void addSection(@Param("section") SectionEntity section);
	
	public void updateSection(@Param("section") SectionEntity section, @Param("id") long id);
	
	public SectionEntity querySectionBySectionId(@Param("sectionId") long sectionId);
}
