/**
 * 
 */
package com.rain.gameCommunity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.service.GameTypeService;
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
}
