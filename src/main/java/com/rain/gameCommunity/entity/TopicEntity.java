package com.rain.gameCommunity.entity;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class TopicEntity implements Serializable {

	// 主题id
	private long id;

	// 用户id
	private long userId;
	
	private String username;

	// 板块id
	private long sectionId;

	// 点击量
	private int clickNum;

	// 回复数量
	private int replyNum;

	// 主题名
	private String topicName;

	// 主题内容
	private String topicText;

	// 主题创建时间
	private String createTime;

	// 最后回复时间
	private String lastReplyTime;

	// 是否置顶
	private boolean isTop;

	// 是否加精
	private boolean isFine;

	public TopicEntity() {
		super();
	}

	public TopicEntity(long id, long userId, long sectionId, int clickNum, int replyNum, String topicName,
			String topicText, String createTime, String lastReplyTime, boolean isTop, boolean isFine) {
		super();
		this.id = id;
		this.userId = userId;
		this.sectionId = sectionId;
		this.clickNum = clickNum;
		this.replyNum = replyNum;
		this.topicName = topicName;
		this.topicText = topicText;
		this.createTime = createTime;
		this.lastReplyTime = lastReplyTime;
		this.isTop = isTop;
		this.isFine = isFine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TopicEntity [id=" + id + ", userId=" + userId + ", sectionId=" + sectionId + ", clickNum=" + clickNum
				+ ", replyNum=" + replyNum + ", topicName=" + topicName + ", topicText=" + topicText + ", createTime="
				+ createTime + ", lastReplyTime=" + lastReplyTime + ", isTop=" + isTop + ", isFine=" + isFine + "]";
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the sectionId
	 */
	public long getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId
	 *            the sectionId to set
	 */
	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @return the clickNum
	 */
	public int getClickNum() {
		return clickNum;
	}

	/**
	 * @param clickNum
	 *            the clickNum to set
	 */
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	/**
	 * @return the replyNum
	 */
	public int getReplyNum() {
		return replyNum;
	}

	/**
	 * @param replyNum
	 *            the replyNum to set
	 */
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	/**
	 * @return the topicName
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * @param topicName
	 *            the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 * @return the topicText
	 */
	public String getTopicText() {
		return topicText;
	}

	/**
	 * @param topicText
	 *            the topicText to set
	 */
	public void setTopicText(String topicText) {
		this.topicText = topicText;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the lastReplyTime
	 */
	public String getLastReplyTime() {
		return lastReplyTime;
	}

	/**
	 * @param lastReplyTime
	 *            the lastReplyTime to set
	 */
	public void setLastReplyTime(String lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}

	/**
	 * @return the isTop
	 */
	public boolean isTop() {
		return isTop;
	}

	/**
	 * @param isTop
	 *            the isTop to set
	 */
	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	/**
	 * @return the isFine
	 */
	public boolean isFine() {
		return isFine;
	}

	/**
	 * @param isFine
	 *            the isFine to set
	 */
	public void setFine(boolean isFine) {
		this.isFine = isFine;
	}

}
