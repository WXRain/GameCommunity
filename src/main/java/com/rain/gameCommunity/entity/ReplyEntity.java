package com.rain.gameCommunity.entity;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

/**
 * @author wangxinyu
 *
 */
@Repository
public class ReplyEntity implements Serializable {

	// 回复id
	private long id;
	
	// 回复用户
	private String username;
	
	// 回复用户id
	private long userId;
	
	// 回复时间
	private String replyTime;
	
	// 回复主题
	private String replyName;
	
	// 回复内容
	private String replyText;
	
	// 回复的是否是评论
	private String isReplyComment;
	
	// 如果回复的是评论，评论的id
	private long replyCommentId;
	
	// 回复的帖子id
	private long replyTopicId;
	
	// 回复的评论
	private ReplyEntity replyComment;

	@Override
	public String toString() {
		return "ReplyEntity [id=" + id + ", username=" + username + ", userId=" + userId + ", replyTime=" + replyTime
				+ ", replyName=" + replyName + ", replyText=" + replyText + ", isReplyComment=" + isReplyComment
				+ ", replyCommentId=" + replyCommentId + ", replyTopicId=" + replyTopicId + ", replyComment="
				+ replyComment + "]";
	}

	public ReplyEntity(long id, String username, long userId, String replyTime, String replyName, String replyText,
			String isReplyComment, long replyCommentId, long replyTopicId, ReplyEntity replyComment) {
		super();
		this.id = id;
		this.username = username;
		this.userId = userId;
		this.replyTime = replyTime;
		this.replyName = replyName;
		this.replyText = replyText;
		this.isReplyComment = isReplyComment;
		this.replyCommentId = replyCommentId;
		this.replyTopicId = replyTopicId;
		this.replyComment = replyComment;
	}

	public ReplyEntity() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getIsReplyComment() {
		return isReplyComment;
	}

	public void setIsReplyComment(String isReplyComment) {
		this.isReplyComment = isReplyComment;
	}

	public long getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(long replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	public long getReplyTopicId() {
		return replyTopicId;
	}

	public void setReplyTopicId(long replyTopicId) {
		this.replyTopicId = replyTopicId;
	}

	public ReplyEntity getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(ReplyEntity replyComment) {
		this.replyComment = replyComment;
	}
	
	
}
