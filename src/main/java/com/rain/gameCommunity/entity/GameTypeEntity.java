package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GameTypeEntity implements Serializable {

	//游戏类型id
	private long id;
	
	//游戏类型名称
	private String typeName;
	
	//游戏类型介绍
	private String introduce;
	
	//游戏类型创建时间
	private Date createTime;
	
	//游戏类型管理员
	private String manager;
	
	//游戏类型管理员实体类型集合
	private List<UserEntity> managers;
	
	//格式化时间
	private String createTimeString;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public String toString() {
		return "GameTypeEntity [id=" + id + ", typeName=" + typeName + ", introduce=" + introduce + ", createTime=" + createTime
				+ ", manager=" + manager + ", managers=" + managers + "]";
	}

	
	
	public GameTypeEntity() {
		
	}



	public GameTypeEntity(long id, String typeName, String introduce, Date createTime, String manager,
			List<UserEntity> managers, String createTimeString, SimpleDateFormat sdf) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.introduce = introduce;
		this.createTime = createTime;
		this.manager = manager;
		this.managers = managers;
		this.createTimeString = createTimeString;
		this.sdf = sdf;
	}



	public SimpleDateFormat getSdf() {
		return sdf;
	}



	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}



	public String getCreateTimeString() {
		return createTimeString;
	}



	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public List<UserEntity> getManagers() {
		return managers;
	}

	public void setManagers(List<UserEntity> managers) {
		this.managers = managers;
	}
	
	
}
