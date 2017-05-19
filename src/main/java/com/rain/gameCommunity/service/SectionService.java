package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.utils.PagingData;
/**
 * 
 * @author wangxinyu
 *
 */
@Component
public interface SectionService {

	public List<SectionEntity> showAllSection() throws Exception;
	
	public List<SectionEntity> showSectionsByGameTypeId(long id, PagingData pagingData) throws Exception;
	
	public List<SectionEntity> showSectionsBySectionId(String id) throws Exception;
	
	public SectionEntity showSectionBySectionId(long sectionId) throws Exception;
	
	public int showSectionsCountBySectionId(long id) throws Exception;
	
	//根据游戏id取出板块信息
	public List<SectionEntity> showSectionByGameId(long gameId) throws Exception;
	
	public void addSection(SectionEntity section) throws Exception;
	
	public void updateSection(SectionEntity section, long id) throws Exception;
	
	public void deleteSectionBySectionId(long sectionId) throws Exception;
	
	public List<SectionEntity> showSectionsByGameTypeId(long gameTypeId) throws Exception;
	
	public SectionEntity showSectionBySectionName(long gameTypeId, String sectionName) throws Exception;
}
