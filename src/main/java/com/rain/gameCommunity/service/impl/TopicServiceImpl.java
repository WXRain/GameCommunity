package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.TopicDAO;
import com.rain.gameCommunity.dao.UserDAO;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDao;
	
	@Autowired
	private UserDAO userDao;

	@Override
	public List<TopicEntity> showAllTopic() throws Exception {
		List<TopicEntity> topics = topicDao.queryAllTopics();
		topics = changeUserIdToString(topics);
		return topics;
	}
	
	
	
	private List<TopicEntity> changeUserIdToString(List<TopicEntity> topics) throws Exception{
		
		for(TopicEntity topic : topics){
			long userId = topic.getUserId();
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userDao.queryUsersById(ids);
			for(UserEntity user : users){
				topic.setUsername(user.getUsername());
			}
		}
		return topics;
	}



	@Override
	public List<TopicEntity> showTopicsBySectionId(String sectionId) throws Exception {
		long sectionLongId = Long.parseLong(sectionId);
		List<TopicEntity> topics = topicDao.queryTopicsBySectionId(sectionLongId);
		topics = changeUserIdToString(topics);
		return topics;
	}



	@Override
	public List<TopicEntity> showTopicsByTopicId(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
