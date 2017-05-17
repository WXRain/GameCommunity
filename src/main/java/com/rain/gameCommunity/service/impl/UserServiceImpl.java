package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.GameDAO;
import com.rain.gameCommunity.dao.UserDAO;
import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.exception.UserNotExitException;
import com.rain.gameCommunity.exception.UserPasswordNotCorrectException;
import com.rain.gameCommunity.exception.UsernameOrPasswordIsNullException;
import com.rain.gameCommunity.service.UserService;
/**
 * 
 * @author wangxinyu
 *
 */
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

	@Override
	public UserEntity checkUser(String username, String password) throws Exception {
		
		//检查账号密码是否为空
		if(username == null){
			throw new UsernameOrPasswordIsNullException("用户名不能为空");
		}
		
		if(password == null){
			throw new UsernameOrPasswordIsNullException("密码不能为空");
		}
		
		username = username.trim();
		password = password.trim();
		
		if(username.length() == 0){
			throw new UsernameOrPasswordIsNullException("用户名不能为空");
		}
		
		if(password.length() == 0){
			throw new UsernameOrPasswordIsNullException("密码不能为空");
		}
		
		UserEntity user = userDao.queryUserByUsername(username);
		
		//用户不存在
		if(user == null || !username.equals(user.getUsername())){
			throw new UserNotExitException("用户不存在");
		}
		
		//用户密码不正确
		if(!password.equals(user.getPasswords())){
			throw new UserPasswordNotCorrectException("用户名或者密码不正确");
		}
		
		user.setPasswords(null);
		return user;
	}

	@Override
	public UserEntity checkOnlyUser(String username) {
		UserEntity user = userDao.queryUserByUsername(username);
		if(user == null){
			return null;
		}else{
			return user;
		}
	}

	@Override
	public void addUser(UserEntity user) throws Exception {
		userDao.addUser(user);
	}

	public List<UserEntity> queryUsersById(List<Long> ids) throws Exception{
		return userDao.queryUsersById(ids);
	}

	@Override
	public void updateUserGames(long userId, String gameIds) throws Exception {
		List<Long> userIds = new ArrayList<Long>();
		userIds.add(userId);
		UserEntity user = new UserEntity();
		List<UserEntity> users = userDao.queryUsersById(userIds);
		if(users != null && users.size() > 0) user = users.get(0);
		else return;
		
		//取出当前已经购买的游戏
		String beforeGames = user.getGames();
		String[] newGames = gameIds.split(",");
		if(beforeGames == null || beforeGames.length() == 0){
			beforeGames = newGames[0] + ",";
		}else{
			beforeGames = beforeGames + "," + newGames[0] + ",";
		}
		for(int i = 1; i < newGames.length; i++){
			beforeGames = beforeGames + newGames[i] + ",";
		}
		
		beforeGames = beforeGames.substring(0, beforeGames.length() - 1);
		
		userDao.updateUserGames(userId, beforeGames);
	}

	/* (non-Javadoc)
	 * @see com.rain.gameCommunity.service.UserService#showUserByUserId(long)
	 */
	@Override
	public UserEntity showUserByUserId(long userId) throws Exception {
		return userDao.queryOneUserByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.rain.gameCommunity.service.UserService#modifyUser(com.rain.gameCommunity.entity.UserEntity)
	 */
	@Override
	public void modifyUser(UserEntity user) throws Exception {
		
		userDao.updateUser(user);
	}
}
