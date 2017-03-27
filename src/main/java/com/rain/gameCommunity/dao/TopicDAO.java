package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.TopicEntity;

@Repository
public interface TopicDAO {

	public List<TopicEntity> queryAllTopics();
	
	public List<TopicEntity> queryTopicsBySectionId(@Param("id") long id, @Param("startLocation") int startLocation,
											@Param("endLocation") int endLocation);
	
	public List<TopicEntity> queryTopicsByTopicId(@Param("id") List<Long> id);
	
	public int queryTopicsCountBySectionId(@Param("id") long id);
}
