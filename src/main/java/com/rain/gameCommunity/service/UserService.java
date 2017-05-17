package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rain.gameCommunity.entity.UserEntity;
/**
 * 
 * @author wangxinyu
 *
 */
@Component
public interface UserService {

	public List<UserEntity> showAllUsers() throws Exception;
	
	public UserEntity checkUser(String username, String password) throws Exception;
	
	public UserEntity checkOnlyUser(String username) throws Exception;
	
	public void addUser(UserEntity user) throws Exception;
	
	public List<UserEntity> queryUsersById(List<Long> ids) throws Exception;
	
	//更新用户已购游戏列表
	public void updateUserGames(long userId, String gameIds) throws Exception;
	
	public UserEntity showUserByUserId(long userId) throws Exception;
	
	public void modifyUser(UserEntity user) throws Exception;
}
