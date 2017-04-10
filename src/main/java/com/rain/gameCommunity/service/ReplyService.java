/**
 * 
 */
package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rain.gameCommunity.entity.ReplyEntity;
import com.rain.gameCommunity.utils.PagingData;

/**
 * @author wangxinyu
 *
 */
@Component
public interface ReplyService {

	public void addReply(ReplyEntity reply) throws Exception;
	
	public List<ReplyEntity> showReplysByTopicId(long topicId, PagingData pagingData) throws Exception;
	
	public int showReplyCountByTopicId(long topicId) throws Exception;
	
	public ReplyEntity showReplyByReplyId(long replyId) throws Exception;
}
