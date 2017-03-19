package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.UserEntity;

@Repository
public interface UserService {

	public List<UserEntity> showAllUsers() throws Exception;
	
	public UserEntity checkUser(String username, String password) throws Exception;
	
	public UserEntity checkOnlyUser(String username) throws Exception;
	
	public void addUser(UserEntity user) throws Exception;
	
	public List<UserEntity> queryUsersById(List<Long> ids) throws Exception;
}
