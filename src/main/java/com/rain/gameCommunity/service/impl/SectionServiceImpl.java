package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.ReplyDAO;
import com.rain.gameCommunity.dao.SectionDAO;
import com.rain.gameCommunity.dao.TopicDAO;
import com.rain.gameCommunity.dao.UserDAO;
import com.rain.gameCommunity.entity.ReplyEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.SectionService;
import com.rain.gameCommunity.utils.PagingData;
/**
 * 
 * @author wangxinyu
 *
 */
@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionDAO sectionDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private TopicDAO topicDao;
	
	@Autowired
	private ReplyDAO replyDao;
	

	public List<SectionEntity> showAllSection() throws Exception {

		List<SectionEntity> sections = sectionDao.queryAllSections();
		sections = changeManagerToString(sections);
		return sections;
	}
	
	private List<SectionEntity> changeManagerToString(List<SectionEntity> sections) throws Exception{
		if(sections == null || sections.size() <= 0) return null;
		for(SectionEntity section : sections){
			String sectionManager = section.getSectionManager();
			if(sectionManager == null || sectionManager.length() <= 0) continue;
			String[] managersString = sectionManager.split(",");
			List<Long> managers = new ArrayList<Long>();
			for(int i = 0; i < managersString.length; i++){
				if(managersString[i] == null || managersString[i].length() <= 0) continue;
				managers.add(Long.parseLong(managersString[i]));
			}
			List<UserEntity> users = userDao.queryUsersById(managers);
			
			section.setManagers(users);
		}
		return sections;
	}
	
	private SectionEntity changeManagerToString(SectionEntity section) throws Exception{
		if(section == null) return null;
		String sectionManager = section.getSectionManager();
		if(sectionManager == null || sectionManager.length() <= 0) return section;
		String[] managersString = sectionManager.split(",");
		List<Long> managers = new ArrayList<Long>();
		for(int i = 0; i < managersString.length; i++){
			if(managersString[i] == null || managersString[i].length() <= 0) continue;
			managers.add(Long.parseLong(managersString[i]));
		}
		List<UserEntity> users = userDao.queryUsersById(managers);
		
		section.setManagers(users);
		return section;
	}

	@Override
	public List<SectionEntity> showSectionsByGameTypeId(long id, PagingData pagingData) throws Exception {
		List<SectionEntity> sections = sectionDao.querySectionsByGameTypeId(id, (pagingData.getTotalPage() -1) * pagingData.getPerPageNum(),
				pagingData.getPerPageNum());
		sections = changeManagerToString(sections);
		return sections;
	}

	@Override
	public List<SectionEntity> showSectionsBySectionId(String id) throws Exception {
		List<Long> ids = new ArrayList<Long>();
		String[] idsString = id.split(",");
		for(int i = 0; i < idsString.length; i++){
			ids.add(Long.parseLong(idsString[i]));
		}
		List<SectionEntity> sections = sectionDao.querySectionsBySectionId(ids);
		sections = changeManagerToString(sections);
		return sections;
	}

	@Override
	public int showSectionsCountBySectionId(long id) throws Exception {
		return sectionDao.querySectionsCountByGameTypeId(id);
	}

	@Override
	public List<SectionEntity> showSectionByGameId(long gameId) throws Exception {
		return sectionDao.querySectionByGameId(gameId);
	}

	@Override
	public void addSection(SectionEntity section) throws Exception {
		sectionDao.addSection(section);
	}

	@Override
	public void updateSection(SectionEntity section, long id) throws Exception {
		
		sectionDao.updateSection(section, id);
	}

	@Override
	public SectionEntity showSectionBySectionId(long sectionId) throws Exception {
		SectionEntity section = sectionDao.querySectionBySectionId(sectionId);
		return changeManagerToString(section);
	}

	@Override
	public void deleteSectionBySectionId(long sectionId) throws Exception {
		
		//删除板块内所有的帖子
		List<TopicEntity> topics = topicDao.queryTopicsBySection(sectionId);
		if(topics != null && topics.size() > 0){
			for(TopicEntity topic : topics){
				//删除当前帖子下的回复
				List<ReplyEntity> replies = replyDao.queryReplysByTopic(topic.getId());
				if(replies != null && replies.size() > 0){
					for(ReplyEntity reply : replies){
						replyDao.deleteReplyByReplyId(reply.getId());
					}
				}
				
				//删除当前帖子
				topicDao.deleteTopicByTopicId(topic.getId());
			}
		}
		
		
		//删除板块
		sectionDao.deleteSectionBySectionId(sectionId);
	}

	@Override
	public List<SectionEntity> showSectionsByGameTypeId(long gameTypeId) throws Exception {
		return sectionDao.querySectionsByGameType(gameTypeId);
	}

}
