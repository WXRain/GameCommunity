package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.utils.PagingData;

@Repository
public interface TopicService {

	public List<TopicEntity> showAllTopic() throws Exception;
	
	public List<TopicEntity> showTopicsBySectionId(long id, PagingData pagingData) throws Exception;
	
	public List<TopicEntity> showTopicsByTopicId(String id) throws Exception;
	
	public int showTopicsCountBySectionId(long id) throws Exception;
}
