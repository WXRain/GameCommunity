package com.rain.gameCommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCotroller {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkUser.do")
	@ResponseBody
	public JsonResult<UserEntity> checkUser(String username, String password){
		UserEntity user;
		try {
			user = userService.checkUser(username, password);
		} catch (Exception e) {
			return new JsonResult<UserEntity>(e.getMessage());
		}
		return new JsonResult<UserEntity>(user);
	}
}
