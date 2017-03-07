package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.UserEntity;

@Repository
public interface UserDAO {

	public List<UserEntity> queryAllUser();
	
	public UserEntity queryUserByUsername(@Param("username") String username);
}
