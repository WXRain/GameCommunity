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
import com.rain.gameCommunity.utils.PagingData;

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
	public List<TopicEntity> showTopicsBySectionId(long sectionId, PagingData pagingData) throws Exception {
		List<TopicEntity> topics = topicDao.queryTopicsBySectionId(sectionId, (pagingData.getCurrentPage()-1) * pagingData.getPerPageNum(),
								pagingData.getPerPageNum());
		topics = changeUserIdToString(topics);
		return topics;
	}



	@Override
	public List<TopicEntity> showTopicsByTopicId(String id) throws Exception {
		String[] topicIdString = id.split(",");
		List<Long> ids = new ArrayList<Long>();
		for(int i = 0; i < topicIdString.length; i++){
			ids.add(Long.parseLong(topicIdString[i]));
		}
		List<TopicEntity> topics = topicDao.queryTopicsByTopicId(ids);
		topics = changeUserIdToString(topics);
		return topics;
		
	}



	@Override
	public int showTopicsCountBySectionId(long id) throws Exception {
		
		return topicDao.queryTopicsCountBySectionId(id);
	}



	@Override
	public int showTopicsCountByCondition(String nameCondition) throws Exception {
		return topicDao.queryTopicsCountByCondition(nameCondition);
	}



	@Override
	public List<TopicEntity> showTopicsByCondition(String nameCondition, PagingData pagingData) throws Exception {
		return changeUserIdToString(topicDao.queryTopicsByCondition(nameCondition, (pagingData.getCurrentPage()-1)*pagingData.getPerPageNum(), pagingData.getPerPageNum()));
	}

}
