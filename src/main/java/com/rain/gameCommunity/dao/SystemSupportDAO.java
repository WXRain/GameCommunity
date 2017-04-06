package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.SystemSupportEntity;

@Repository
public interface SystemSupportDAO {

	public List<SystemSupportEntity> queryAllSystemSupport();
	
	public SystemSupportEntity querySystemSupportById(@Param("id") long id);
	
	public long addSystemSupport(@Param("systemSupport") SystemSupportEntity systemSupport);
}
