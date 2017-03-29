package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserEntity implements Serializable {

	// 用户id
	private long id;

	// 用户名
	private String username;

	// 密码
	private String passwords;

	// 注册时间
	private Date registerTime;
	
	private String registerTimeString;

	// 性别
	private int sex = -1;

	// 等级
	private int levels = 0;

	// 经验
	private int exp = 0;

	// 是否是管理员
	private int isManager = 0;

	// 介绍
	private String introduce = "";

	// 头像路径
	private String head = "";

	// 已经买的游戏
	private String games = "";

	// 已经购买的游戏的列表
	private List<GameEntity> hasBuyedGames = null;
	
	//日期格式化
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String formatDate(long time){
		return sdf.format(time);
	}
	
	public UserEntity() {
		super();
	}

	public UserEntity(long id, String username, String passwords, Date registerTime, int sex, int levels, int exp,
			int isManager, String introduce, String head, String games, List<GameEntity> hasBuyedGames) {
		super();
		this.id = id;
		this.username = username;
		this.passwords = passwords;
		this.registerTime = registerTime;
		this.sex = sex;
		this.levels = levels;
		this.exp = exp;
		this.isManager = isManager;
		this.introduce = introduce;
		this.head = head;
		this.games = games;
		this.hasBuyedGames = hasBuyedGames;
		this.registerTimeString = sdf.format(registerTime);
;	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", passwords=" + passwords + ", registerTime="
				+ registerTime + ", sex=" + sex + ", levels=" + levels + ", exp=" + exp + ", isManager=" + isManager
				+ ", introduce=" + introduce + ", head=" + head + ", games=" + games + ", hasBuyedGames="
				+ hasBuyedGames + "]";
	}
	
	

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public String getRegisterTimeString() {
		return registerTimeString;
	}

	public void setRegisterTimeString(String registerTimeString) {
		this.registerTimeString = registerTimeString;
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
	public String getPasswords() {
		return passwords;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	/**
	 * @return the registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime
	 *            the registerTime to set
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
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
	public int getLevels() {
		return levels;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevels(int levels) {
		this.levels = levels;
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
