package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameDAO;
import com.rain.gameCommunity.dao.UserDAO;
import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Autowired
	GameDAO gameDao;

	@Override
	public List<UserEntity> showAllUsers() throws Exception {
		List<UserEntity> users = userDao.queryAllUser();
		for (UserEntity user : users) {
			String games = user.getGames();
			String[] gameArray = games.split(",");
			List<GameEntity> hasBuyedGames = new ArrayList<GameEntity>();
			for (int i = 0; i < gameArray.length; i++) {
				GameEntity game = gameDao.queryGameById(Integer.parseInt(gameArray[i]));
				hasBuyedGames.add(game);
			}
			user.setHasBuyedGames(hasBuyedGames);
		}
		return users;
	}

}
