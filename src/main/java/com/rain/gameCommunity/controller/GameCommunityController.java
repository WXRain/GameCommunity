package com.rain.gameCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.TopicService;
import com.rain.gameCommunity.utils.JsonResult;
import com.rain.gameCommunity.utils.PagingData;

/**
 * 
 * @author wangxinyu
 *
 */

@Controller
public class GameCommunityController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/searchGame.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> searchGame(String nameCondition, int currentPage){
		PagingData pagingData = new PagingData();
		try{
			pagingData.setTotalNum(gameService.queryGameCountByNameCondition(nameCondition));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<GameEntity> games = gameService.showGameByCondition(nameCondition, pagingData);
			return new JsonResult<List<GameEntity>>(games, pagingData);
		}catch(Exception e){
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
		
	}
	
	@RequestMapping("/searchCommunity.do")
	@ResponseBody
	public JsonResult<List<TopicEntity>> searchTopic(String nameCondition, int currentPage){
		PagingData pagingData = new PagingData();
		try{
			pagingData.setTotalNum(topicService.showTopicsCountByCondition(nameCondition));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<TopicEntity> topics = topicService.showTopicsByCondition(nameCondition, pagingData);
			return new JsonResult<List<TopicEntity>>(topics, pagingData);
		}catch(Exception e){
			return new JsonResult<List<TopicEntity>>(e.getMessage());
		}
	}
}
