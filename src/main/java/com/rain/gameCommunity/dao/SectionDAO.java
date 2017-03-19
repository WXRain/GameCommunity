package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rain.gameCommunity.entity.SectionEntity;

public interface SectionDAO {

	public List<SectionEntity> queryAllSections();
	
	public List<SectionEntity> querySectionsByGameTypeId(@Param("id") long id);
}
