package com.rain.gameCommunity.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.TopicEntity;

@Repository
public interface TopicDAO {

	public List<TopicEntity> queryAllTopics();
}
