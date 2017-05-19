/**
 * 
 */
package com.rain.gameCommunity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.service.SectionService;
import com.rain.gameCommunity.utils.JsonResult;

/**
 * @author wangxinyu
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {

	@Autowired
	GameTypeService gameTypeService;
	
	@Autowired
	GameService gameService;
	
	@Autowired
	SectionService sectionService;
	
	@RequestMapping("/addGameType.do")
	@ResponseBody
	public JsonResult<Boolean> addGameType(String gameTypeName, String gameTypeIntroduce){
		try{
			
			GameTypeEntity gameType = gameTypeService.queryGameTypeByName(gameTypeName);
			if(gameType == null){
				gameType = new GameTypeEntity();
				gameType.setTypeName(gameTypeName);
				gameType.setIntroduce(gameTypeIntroduce);
			}else{
				throw new Exception("游戏类型已存在！");
			}
			gameTypeService.addGameType(gameType);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/deleteGameType.do")
	@ResponseBody
	@Transactional
	public JsonResult<Boolean> deleteGameType(long gameTypeId){
		try{
			
			//删除游戏类型中的游戏
			List<GameEntity> games = gameService.showGameByGameType(gameTypeId);
			if(games != null && games.size() > 0){
				for(GameEntity game : games){
					gameService.deleteGameByGameId(game.getId());
				}
			}
			
			//删除游戏类型中的板块
			List<SectionEntity> sections = sectionService.showSectionsByGameTypeId(gameTypeId);
			if(sections != null && sections.size() > 0){
				for(SectionEntity section : sections){
					sectionService.deleteSectionBySectionId(section.getId());
				}
			}
			
			//删除游戏类型
			gameTypeService.deleteGameTypeByGameTypeId(gameTypeId);
			
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/updateManager.do")
	@ResponseBody
	public JsonResult<Boolean> updateManager(long gameTypeId, String manager){
		try{
			GameTypeEntity gameType = gameTypeService.queryGameTypeById(gameTypeId);
			gameType.setManager(manager);
			System.out.println(gameType.getTypeName());
			gameTypeService.updateGameType(gameType);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/checkOnlyGameType.do")
	@ResponseBody
	public JsonResult<Boolean> checkOnlyGameType(String gameTypeName){
		try{
			GameTypeEntity gameType = gameTypeService.queryGameTypeByName(gameTypeName);
			if(gameType != null){
				throw new Exception("游戏类型重复！");
			}
			return new JsonResult<Boolean>(true, null);
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
}
