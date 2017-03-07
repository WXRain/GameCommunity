package com.rain.gameCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.TopicDAO;
import com.rain.gameCommunity.entity.TopicEntity;
import com.rain.gameCommunity.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDao;

	@Override
	public List<TopicEntity> showAllTopic() throws Exception {
		return topicDao.queryAllTopics();
	}

}
