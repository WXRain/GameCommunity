package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.SectionEntity;

@Repository
public interface SectionService {

	public List<SectionEntity> showAllSection() throws Exception;
	
	public List<SectionEntity> showSectionsByGameTypeId(long id) throws Exception;
	
	public List<SectionEntity> showSectionsBySectionId(String id) throws Exception;
	
	public int showSectionsCountBySectionId(long id) throws Exception;
	
	//根据游戏id取出板块信息
	public List<SectionEntity> showSectionByGameId(long gameId) throws Exception;
}
