package com.rain.gameCommunity.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.UserEntity;

@Repository
public interface UserDAO {

	public List<UserEntity> queryAllUser();
}
