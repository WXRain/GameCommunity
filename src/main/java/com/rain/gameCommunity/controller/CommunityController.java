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
	public JsonResult<List<GameTypeEntity>> initMain(){
		try{
			List<GameTypeEntity> gameTypes = gameTypeService.showAllGameTypes();
			return new JsonResult<List<GameTypeEntity>>(gameTypes);
		}catch(Exception e){
			return new JsonResult<List<GameTypeEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/initGameType.do")
	@ResponseBody
	public JsonResult<List<SectionEntity>> initGameType(String gameTypeId){
		try{
			List<SectionEntity> sections = sectionService.showSectionsByGameTypeId(Long.parseLong(gameTypeId));
			return new JsonResult<List<SectionEntity>>(sections);
		}catch(Exception e){
			return new JsonResult<List<SectionEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/showGameType.do")
	@ResponseBody
	public JsonResult<GameTypeEntity> showGameType(String gameTypeId){
		try{
			GameTypeEntity gameTypeEntity = gameTypeService.queryGameTypeById(Long.parseLong(gameTypeId));
			return new JsonResult<GameTypeEntity>(gameTypeEntity);
		}catch(Exception e){
			return new JsonResult<GameTypeEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/initSection.do")
	@ResponseBody
	public JsonResult<List<TopicEntity>> initSection(String sectionId){
		try{
			List<TopicEntity> topics = topicService.showTopicsBySectionId(sectionId);
			return new JsonResult<List<TopicEntity>>(topics);
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
			return new JsonResult<SectionEntity>(section);
		}catch(Exception e){
			return new JsonResult<SectionEntity>(e.getMessage());
		}
	}
	

	public GameTypeService getGameTypeService() {
		return gameTypeService;
	}

	public void setGameTypeService(GameTypeService gameTypeService) {
		this.gameTypeService = gameTypeService;
	}

	public String getGameTypeName() {
		return gameTypeName;
	}

	public void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}
	
	
}
