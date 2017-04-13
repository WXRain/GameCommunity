package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.utils.PagingData;
/**
 * 
 * @author wangxinyu
 *
 */
@Component
public interface TopicService {

	public List<TopicEntity> showAllTopic() throws Exception;
	
	public List<TopicEntity> showTopicsBySectionId(long id, PagingData pagingData) throws Exception;
	
	public List<TopicEntity> showTopicsByTopicId(String id) throws Exception;
	
	public int showTopicsCountBySectionId(long id) throws Exception;
	
	public int showTopicsCountByCondition(String nameCondition) throws Exception;
	
	public List<TopicEntity> showTopicsByCondition(String nameCondition, PagingData pagingData) throws Exception;
	
	public void updateTopic(TopicEntity topic) throws Exception;
	
	public void addTopic(TopicEntity topic) throws Exception;
	
	public TopicEntity showTopicByTopicId(long topicId) throws Exception;
}
