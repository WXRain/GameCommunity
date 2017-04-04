package com.rain.gameCommunity.entity;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GameEntity implements Serializable {

	// 游戏ID
	private long id;

	// 游戏大小
	private String size;

	// 游戏创建时间
	private String buildDate;

	// 游戏名称
	private String gameName;

	// 游戏评论
	private List<CommentEntity> comments;

	// 游戏介绍
	private String introduce;

	// 游戏价格
	private double price;

	// 游戏折扣
	private double cutOff;

	// 系统支持类型
	private int systemTypeNum;

	// 游戏封面
	private List<File> pictures;

	// 游戏版本
	private String version;

	// 游戏路径
	private String path;

	// 系统支持对象
	private SystemSupportEntity systemSupport;

	// 对应的板块ID
	private int sectionId;
	
	// 游戏下载量
	private int downloadNum;
	
	//游戏类型
	private long gameType;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public GameEntity() {
		this.cutOff = 1;
		this.version = "1.0.0";

	}

	public GameEntity(long id, String size, String buildDate, String gameName, List<CommentEntity> comments,
			String introduce, double price, double cutOff, int systemTypeNum, List<File> pictures, String version,
			String path, SystemSupportEntity systemSupport, int sectionId, int downloadNum, long gameType) {
		super();
		this.id = id;
		this.size = size;
		this.buildDate = buildDate;
		this.gameName = gameName;
		this.comments = comments;
		this.introduce = introduce;
		this.price = price;
		this.cutOff = cutOff;
		this.systemTypeNum = systemTypeNum;
		this.pictures = pictures;
		this.version = version;
		this.path = path;
		this.systemSupport = systemSupport;
		this.sectionId = sectionId;
		this.downloadNum = downloadNum;
		this.gameType = gameType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameEntity [id=" + id + ", size=" + size + ", buildDate=" + buildDate + ", gameName=" + gameName
				+ ", comments=" + comments + ", introduce=" + introduce + ", price=" + price + ", cutOff=" + cutOff
				+ ", systemTypeNum=" + systemTypeNum + ", pictures=" + pictures + ", version=" + version + ", path="
				+ path + ", systemSupport=" + systemSupport + ", sectionId=" + sectionId + ", downloadNum=" + downloadNum +
				", gameType=" + gameType + "]";
	}
	
	

	public long getGameType() {
		return gameType;
	}

	public void setGameType(long gameType) {
		this.gameType = gameType;
	}

	public int getDownloadNum() {
		return downloadNum;
	}

	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	/**
	 * @return the gameNum
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param gameNum
	 *            the gameNum to set
	 */
	public void setGameNum(long id) {
		this.id = id;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the buildDate
	 */
	public String getBuildDate() {
		return buildDate;
	}

	/**
	 * @param buildDate
	 *            the buildDate to set
	 */
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName
	 *            the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the comments
	 */
	public List<CommentEntity> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the cutOff
	 */
	public double getCutOff() {
		return cutOff;
	}

	/**
	 * @param cutOff
	 *            the cutOff to set
	 */
	public void setCutOff(double cutOff) {
		this.cutOff = cutOff;
	}

	/**
	 * @return the systemTypeNum
	 */
	public int getSystemTypeNum() {
		return systemTypeNum;
	}

	/**
	 * @param systemTypeNum
	 *            the systemTypeNum to set
	 */
	public void setSystemTypeNum(int systemTypeNum) {
		this.systemTypeNum = systemTypeNum;
	}

	/**
	 * @return the pictures
	 */
	public List<File> getPictures() {
		return pictures;
	}

	/**
	 * @param pictures
	 *            the pictures to set
	 */
	public void setPictures(List<File> pictures) {
		this.pictures = pictures;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the systemSupport
	 */
	public SystemSupportEntity getSystemSupport() {
		return systemSupport;
	}

	/**
	 * @param systemSupport
	 *            the systemSupport to set
	 */
	public void setSystemSupport(SystemSupportEntity systemSupport) {
		this.systemSupport = systemSupport;
	}

	/**
	 * @return the sectionId
	 */
	public int getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId
	 *            the sectionId to set
	 */
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

}
