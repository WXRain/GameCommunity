package com.rain.gameCommunity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.ReplyEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.service.ReplyService;
import com.rain.gameCommunity.service.SectionService;
import com.rain.gameCommunity.service.TopicService;
import com.rain.gameCommunity.utils.JsonResult;
import com.rain.gameCommunity.utils.PagingData;

/**
 * 
 * @author wangxinyu
 *
 */

@Controller
@RequestMapping("/community")
public class CommunityController {

	@Autowired
	private GameTypeService gameTypeService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private ReplyService replyService;
	
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
			List<SectionEntity> sections = sectionService.showSectionsByGameTypeId(gameTypeId, pagingData);
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
			topic.setClickNum(topic.getClickNum() + 1);
			//更新点击量
			topicService.updateTopic(topic);
			return new JsonResult<TopicEntity>(topic, null);
		}catch(Exception e){
			return new JsonResult<TopicEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/addTopic.do")
	@ResponseBody
	@Transactional
	public JsonResult<Boolean> addTopic(long userId, long sectionId, String topicName, String topicText){
		try{
			
			SectionEntity section = sectionService.showSectionBySectionId(sectionId);
			if(section == null) throw new Exception("板块错误！");
			section.setTopicNum(section.getTopicNum() + 1);
			sectionService.updateSection(section, sectionId);
			
			TopicEntity topic = new TopicEntity();
			topic.setTopicName(topicName);
			topic.setTopicText(topicText);
			topic.setUserId(userId);
			topic.setSectionId(sectionId);
			topicService.addTopic(topic);
			
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/showReply.do")
	@ResponseBody
	public JsonResult<List<ReplyEntity>> showReply(long topicId, int currentPage){
		PagingData pagingData = new PagingData();
		try{
			if(currentPage == 0) currentPage = 1;
			pagingData.setTotalNum(replyService.showReplyCountByTopicId(topicId));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<ReplyEntity> replys = replyService.showReplysByTopicId(topicId, pagingData);
			return new JsonResult<List<ReplyEntity>>(replys, pagingData);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<ReplyEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/addReply.do")
	@ResponseBody
	@Transactional
	public JsonResult<Boolean> addReply(long userId, String username, String replyName, String replyText, String isReplyComment, 
			long replyCommentId, long replyTopicId){
		ReplyEntity reply = new ReplyEntity();
		try{
			reply.setUserId(userId);
			reply.setUsername(username);
			reply.setReplyName(replyName);
			reply.setReplyText(replyText);
			reply.setIsReplyComment(isReplyComment);
			reply.setReplyCommentId(replyCommentId);
			reply.setReplyTopicId(replyTopicId);
			replyService.addReply(reply);
			System.out.println("更新回复数据库成功！");
			
			//更新帖子回复数量
			TopicEntity topic = topicService.showTopicByTopicId(replyTopicId);
			if(topic==null) throw new Exception("执行出错！");
			topic.setReplyNum(topic.getReplyNum() + 1);
			topicService.updateTopic(topic);
			
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addSection.do")
	@ResponseBody
	public JsonResult<Boolean> addSection(String sectionName, String sectionIntroduce, long gameTypeId){
		try{
			SectionEntity section = new SectionEntity();
			section.setGameType(gameTypeId);
			section.setName(sectionName);
			section.setIntroduce(sectionIntroduce);
			
			sectionService.addSection(section);
			
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/deleteSection.do")
	@ResponseBody
	public JsonResult<Boolean> deleteSection(long sectionId){
		try{
			sectionService.deleteSectionBySectionId(sectionId);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/deleteTopic.do")
	@ResponseBody
	public JsonResult<Boolean> deleteTopic(long topicId){
		try{
			topicService.deleteTopicByTopicId(topicId);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/deleteReply.do")
	@ResponseBody
	public JsonResult<Boolean> deleteReply(long replyId){
		try{
			replyService.deleteReplyByReplyId(replyId);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addTop.do")
	@ResponseBody
	public JsonResult<Boolean> addTop(long topicId){
		try{
			TopicEntity topic = topicService.showTopicByTopicId(topicId);
			topic.setIsTop("1");
			topicService.updateTopic(topic);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/cancelTop.do")
	@ResponseBody
	public JsonResult<Boolean> cancelTop(long topicId){
		try{
			TopicEntity topic = topicService.showTopicByTopicId(topicId);
			topic.setIsTop("0");
			topicService.updateTopic(topic);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addFine.do")
	@ResponseBody
	public JsonResult<Boolean> addFine(long topicId){
		try{
			TopicEntity topic = topicService.showTopicByTopicId(topicId);
			topic.setIsFine("1");
			topicService.updateTopic(topic);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/cancelFine.do")
	@ResponseBody
	public JsonResult<Boolean> cancelFine(long topicId){
		try{
			TopicEntity topic = topicService.showTopicByTopicId(topicId);
			topic.setIsFine("0");
			topicService.updateTopic(topic);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}

	public String getGameTypeName() {
		return gameTypeName;
	}

	public void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}
	
	
}
