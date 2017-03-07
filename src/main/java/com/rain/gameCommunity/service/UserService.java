package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.UserEntity;

@Repository
public interface UserService {

	public List<UserEntity> showAllUsers() throws Exception;
	
	public UserEntity checkUser(String username, String password) throws Exception;
}
