package com.rain.gameCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.service.SectionService;

@Controller
@RequestMapping("/community")
public class CommunityController {

	@Autowired
	private GameTypeService gameTypeService;
	
	@Autowired
	private SectionService sectionService;
	
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
	public JsonResult<List<SectionEntity>> initGameType(){
		try{
			List<SectionEntity> sections = sectionService.showAllSection();
			return new JsonResult<List<SectionEntity>>(sections);
		}catch(Exception e){
			return new JsonResult<List<SectionEntity>>(e.getMessage());
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
