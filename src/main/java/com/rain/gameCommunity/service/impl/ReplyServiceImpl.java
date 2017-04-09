/**
 * 
 */
package com.rain.gameCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.ReplyDAO;
import com.rain.gameCommunity.entity.ReplyEntity;
import com.rain.gameCommunity.service.ReplyService;
import com.rain.gameCommunity.utils.PagingData;

/**
 * @author wangxinyu
 *
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDao;
	
	@Override
	public void addReply(ReplyEntity reply) throws Exception {
		
		replyDao.addReply(reply);
	}

	@Override
	public List<ReplyEntity> showReplysByTopicId(long topicId, PagingData pagingData) throws Exception {
		
		return replyDao.queryReplysByTopicId(topicId, (pagingData.getTotalPage() -1) * pagingData.getPerPageNum(),
				pagingData.getPerPageNum());
	}

	@Override
	public int showReplyCountByTopicId(long topicId) throws Exception {
		return replyDao.queryReplyCountByTopicId(topicId);
	}

}
