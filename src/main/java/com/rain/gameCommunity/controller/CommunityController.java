package com.rain.gameCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.service.SectionService;
import com.rain.gameCommunity.service.TopicService;
import com.rain.gameCommunity.utils.JsonResult;
import com.rain.gameCommunity.utils.PagingData;

@Controller
@RequestMapping("/community")
public class CommunityController {

	@Autowired
	private GameTypeService gameTypeService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private TopicService topicService;
	
	private String gameTypeName;
	
	@RequestMapping("/initMain.do")
	@ResponseBody
	public JsonResult<List<GameTypeEntity>> initMain(int currentPage){
		List<GameTypeEntity> gameTypes;
		PagingData pagingData = new PagingData();
		if(currentPage == 0) currentPage = 1;
		try{
			pagingData.setCurrentPage(currentPage);
			pagingData.setTotalNum(gameTypeService.queryGameTypeCount());
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			
			gameTypes = gameTypeService.showGameTypesByPage(pagingData);
		}catch(Exception e){
			return new JsonResult<List<GameTypeEntity>>(e.getMessage());
		}
		return new JsonResult<List<GameTypeEntity>>(gameTypes, pagingData);
	}
	
	@RequestMapping("/initGameType.do")
	@ResponseBody
	public JsonResult<List<SectionEntity>> initGameType(long gameTypeId, int currentPage){
		PagingData pagingData = new PagingData();
		try{
			if(currentPage == 0) currentPage = 1;
			pagingData.setTotalNum(sectionService.showSectionsCountBySectionId(gameTypeId));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<SectionEntity> sections = sectionService.showSectionsByGameTypeId(gameTypeId);
			return new JsonResult<List<SectionEntity>>(sections, pagingData);
		}catch(Exception e){
			return new JsonResult<List<SectionEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/showGameType.do")
	@ResponseBody
	public JsonResult<GameTypeEntity> showGameType(String gameTypeId){
		try{
			GameTypeEntity gameTypeEntity = gameTypeService.queryGameTypeById(Long.parseLong(gameTypeId));
			return new JsonResult<GameTypeEntity>(gameTypeEntity, null);
		}catch(Exception e){
			return new JsonResult<GameTypeEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/initSection.do")
	@ResponseBody
	public JsonResult<List<TopicEntity>> initSection(long sectionId, int currentPage){
		PagingData pagingData = new PagingData();
		
		try{
			System.out.println(topicService.showTopicsCountBySectionId(sectionId));
			pagingData.setTotalNum(topicService.showTopicsCountBySectionId(sectionId));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<TopicEntity> topics = topicService.showTopicsBySectionId(sectionId, pagingData);
			return new JsonResult<List<TopicEntity>>(topics, pagingData);
		}catch(Exception e){
			return new JsonResult<List<TopicEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/showSection.do")
	@ResponseBody
	public JsonResult<SectionEntity> showSection(String sectionId){
		try{
			List<SectionEntity> sections = sectionService.showSectionsBySectionId(sectionId);
			if(sections == null || sections.size() <= 0) throw new Exception("系统错误");
			SectionEntity section = sectionService.showSectionsBySectionId(sectionId).get(0);
			return new JsonResult<SectionEntity>(section, null);
		}catch(Exception e){
			return new JsonResult<SectionEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/initTopic.do")
	@ResponseBody
	public JsonResult<TopicEntity> initTopic(String topicId){
		try{
			List<TopicEntity> topics = topicService.showTopicsByTopicId(topicId);
			TopicEntity topic = new TopicEntity();
			if(topics == null || topics.size() <= 0) 
				return new JsonResult<TopicEntity>(null, null);
			topic = topics.get(0);
			return new JsonResult<TopicEntity>(topic, null);
		}catch(Exception e){
			return new JsonResult<TopicEntity>(e.getMessage());
		}
	}

	public String getGameTypeName() {
		return gameTypeName;
	}

	public void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}
	
	
}
