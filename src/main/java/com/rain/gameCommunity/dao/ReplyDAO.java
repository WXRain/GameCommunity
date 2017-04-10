package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.ReplyEntity;

/**
 * @author wangxinyu
 *
 */

@Repository
public interface ReplyDAO {

	public void addReply(@Param("reply") ReplyEntity reply);
	
	public List<ReplyEntity> queryReplysByTopicId(@Param("topicId") long topicId, @Param("startLocation") int startLocation,
												@Param("perPageNum") int perPageNum);
	
	public int queryReplyCountByTopicId(@Param("topicId") long topicId);
	
	public ReplyEntity queryReplyByReplyId(@Param("replyId") long replyId);
}
