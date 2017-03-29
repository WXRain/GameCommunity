package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SectionEntity implements Serializable {

	// 板块ID
	private long id;

	// 板块名
	private String name;

	// 板块介绍
	private String introduce;

	// 板块主题数量
	private int topicNum;

	// 板块管理员
	private String sectionManager;

	// 板块创建时间
	private String createTime;

	// 对应游戏ID
	private long gameId;
	
	private List<UserEntity> managers;

	public SectionEntity() {
		super();
	}

	public SectionEntity(long id, String name, String introduce, int topicNum, String sectionManager, String createTime,
			long gameId, List<UserEntity> managers) {
		super();
		this.id = id;
		this.name = name;
		this.introduce = introduce;
		this.topicNum = topicNum;
		this.sectionManager = sectionManager;
		this.createTime = createTime;
		this.gameId = gameId;
		this.managers = managers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SectionEntity [id=" + id + ", name=" + name + ", introduce=" + introduce + ", topicNum=" + topicNum
				+ ", sectionManager=" + sectionManager + ", createTime=" + createTime + ", gameId=" + gameId + ", managers=" + managers + "]";
	}

	
	
	public List<UserEntity> getManagers() {
		return managers;
	}

	public void setManagers(List<UserEntity> managers) {
		this.managers = managers;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * @param introduce
	 *            the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * @return the topicNum
	 */
	public int getTopicNum() {
		return topicNum;
	}

	/**
	 * @param topicNum
	 *            the topicNum to set
	 */
	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}

	/**
	 * @return the sectionManager
	 */
	public String getSectionManager() {
		return sectionManager;
	}

	/**
	 * @param sectionManager
	 *            the sectionManager to set
	 */
	public void setSectionManager(String sectionManager) {
		this.sectionManager = sectionManager;
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
	 * @return the gameId
	 */
	public long getGameId() {
		return gameId;
	}

	/**
	 * @param gameId
	 *            the gameId to set
	 */
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

}
