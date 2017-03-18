package com.rain.gameCommunity.controller;

import java.util.Date;

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
	
	@RequestMapping("/checkOnlyUsername.do")
	@ResponseBody
	public JsonResult<UserEntity> checkOnlyUser(String username){
		try{
			UserEntity user = userService.checkOnlyUser(username);
			if(user == null){
				return new JsonResult<UserEntity>(0, null, null);
			}else{
				return new JsonResult<UserEntity>(1, "用户名已存在", null);
			}
		}catch(Exception e){
			return new JsonResult<UserEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/registerUser.do")
	@ResponseBody
	public JsonResult<UserEntity> registerUser(String username, String password) throws Exception{
		UserEntity user = new UserEntity();
		try{
			user.setUsername(username);
			user.setPassword(password);
			user.setRegisterTime(new Date());
			userService.addUser(user);
			System.out.println("success");
			return new JsonResult<UserEntity>(0, "注册成功", null);
		}catch(Exception e){
			return new JsonResult<UserEntity>(e.getMessage());
		}
	}
}
