package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rain.gameCommunity.entity.SectionEntity;

public interface SectionDAO {

	public List<SectionEntity> queryAllSections();
	
	public List<SectionEntity> querySectionsByGameTypeId(@Param("id") long id);
	
	public List<SectionEntity> querySectionsBySectionId(@Param("id") List<Long> id);
	
	public Integer querySectionsCountByGameTypeId(@Param("id") long id);
}
