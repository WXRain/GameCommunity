package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserEntity implements Serializable {

	// 用户id
	private long id;

	// 用户名
	private String username;

	// 密码
	private String password;

	// 注册时间
	private String registeTime;

	// 性别
	private int sex;

	// 等级
	private int level;

	// 经验
	private int exp;

	// 是否是管理员
	private int isManager;

	// 介绍
	private String introduce;

	// 头像路径
	private String head;

	// 已经买的游戏
	private String games;

	// 已经购买的游戏的列表
	private List<GameEntity> hasBuyedGames;

	public UserEntity() {
		super();
	}

	public UserEntity(long id, String username, String password, String registeTime, int sex, int level, int exp,
			int isManager, String introduce, String head, String games, List<GameEntity> hasBuyedGames) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.registeTime = registeTime;
		this.sex = sex;
		this.level = level;
		this.exp = exp;
		this.isManager = isManager;
		this.introduce = introduce;
		this.head = head;
		this.games = games;
		this.hasBuyedGames = hasBuyedGames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", registeTime="
				+ registeTime + ", sex=" + sex + ", level=" + level + ", exp=" + exp + ", isManager=" + isManager
				+ ", introduce=" + introduce + ", head=" + head + ", games=" + games + ", hasBuyedGames="
				+ hasBuyedGames + "]";
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the registeTime
	 */
	public String getRegisteTime() {
		return registeTime;
	}

	/**
	 * @param registeTime
	 *            the registeTime to set
	 */
	public void setRegisteTime(String registeTime) {
		this.registeTime = registeTime;
	}

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * @param exp
	 *            the exp to set
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * @return the isManager
	 */
	public int getIsManager() {
		return isManager;
	}

	/**
	 * @param isManager
	 *            the isManager to set
	 */
	public void setIsManager(int isManager) {
		this.isManager = isManager;
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
	 * @return the head
	 */
	public String getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * @return the games
	 */
	public String getGames() {
		return games;
	}

	/**
	 * @param games
	 *            the games to set
	 */
	public void setGames(String games) {
		this.games = games;
	}

	/**
	 * @return the hasBuyedGames
	 */
	public List<GameEntity> getHasBuyedGames() {
		return hasBuyedGames;
	}

	/**
	 * @param hasBuyedGames
	 *            the hasBuyedGames to set
	 */
	public void setHasBuyedGames(List<GameEntity> hasBuyedGames) {
		this.hasBuyedGames = hasBuyedGames;
	}

}
