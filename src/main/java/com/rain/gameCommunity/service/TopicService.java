package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.TopicEntity;

@Repository
public interface TopicService {

	public List<TopicEntity> showAllTopic() throws Exception;
	
	public List<TopicEntity> showTopicsBySectionId(String id) throws Exception;
	
	public List<TopicEntity> showTopicsByTopicId(String id) throws Exception;
}
