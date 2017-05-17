package com.rain.gameCommunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.UserEntity;
/**
 * 
 * @author wangxinyu
 *
 */
@Repository
public interface UserDAO {

	public List<UserEntity> queryAllUser();
	
	public UserEntity queryUserByUsername(@Param("username") String username);
	
	public void addUser(@Param("user") UserEntity user);
	
	public List<UserEntity> queryUsersById(@Param("id") List<Long> id);
	
	//更新已经购买的游戏
	public void updateUserGames(@Param("userId") long userId, @Param("gameIds") String gameIds);
	
	public UserEntity queryOneUserByUserId(@Param("userId") long userId);
	
	public void updateUser(@Param("user") UserEntity user);
	
}
