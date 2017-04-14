/**
 * 
 */
package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<ReplyEntity> showReplysByTopicId(long topicId, PagingData pagingData) throws Exception {
		
		return setCommentByCommentId(replyDao.queryReplysByTopicId(topicId, (pagingData.getCurrentPage() -1) * pagingData.getPerPageNum(),
				pagingData.getPerPageNum()));
	}

	@Override
	public int showReplyCountByTopicId(long topicId) throws Exception {
		return replyDao.queryReplyCountByTopicId(topicId);
	}
	
	private List<ReplyEntity> setCommentByCommentId(List<ReplyEntity> replies){
		if(replies != null && replies.size() > 0){
			for(int i = 0; i < replies.size(); i++){
				if(replies.get(i).getIsReplyComment() == null || "".equals(replies.get(i).getIsReplyComment())) continue;
				replies.get(i).setReplyComment(replyDao.queryReplyByReplyId(replies.get(i).getReplyCommentId()));
			}
		}
		return replies;
	}

	@Override
	public ReplyEntity showReplyByReplyId(long replyId) throws Exception {
		return replyDao.queryReplyByReplyId(replyId);
	}

	/* (non-Javadoc)
	 * @see com.rain.gameCommunity.service.ReplyService#deleteReplyByReplyId(long)
	 */
	@Override
	public void deleteReplyByReplyId(long replyId) throws Exception {
		
		List<Long> shuzu = new ArrayList<Long>();
		shuzu.add(replyId);
		while(shuzu.size() > 0){
			for(int i = 0; i < shuzu.size(); i++){
				List<ReplyEntity> replies = replyDao.queryRepliesByReplyCommentId(shuzu.get(i));
				if(replies != null && replies.size() > 0){
					for(ReplyEntity reply : replies) shuzu.add(reply.getId());
				}
				replyDao.deleteReplyByReplyId(shuzu.get(i));
				shuzu.set(i, -1L);
			}
			while(shuzu.remove(-1L));
		}
	}

}
