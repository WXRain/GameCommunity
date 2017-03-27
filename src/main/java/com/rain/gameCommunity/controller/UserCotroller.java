package com.rain.gameCommunity.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.UserService;
import com.rain.gameCommunity.utils.JsonResult;

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
				return new JsonResult<UserEntity>(0, null, null, null);
			}else{
				return new JsonResult<UserEntity>(1, "用户名已存在", null, null);
			}
		}catch(Exception e){
			return new JsonResult<UserEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/registerUser.do")
	@ResponseBody
	public JsonResult<UserEntity> registerUser(
			MultipartFile file, HttpServletRequest request) throws Exception{
		UserEntity user = new UserEntity();	
		try{
			System.out.println("注册账号中……");
			user.setUsername(request.getParameter("username"));
			user.setPasswords(request.getParameter("passwords"));
			user.setRegisterTime(new Date());
			
			if(!file.isEmpty()){
				//处理头像
				String path = request.getSession().getServletContext().getRealPath("uploadFloder/users/head");
				String filename = file.getOriginalFilename();//xxx.jpg
				System.out.println(filename);
				String[] names = filename.split("\\.");
				System.out.println(names[0]);
				String newFileName = user.getRegisterTime().getTime() + "." + names[names.length-1];
				
				File targetFile = new File(path, newFileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();//不存在则新建目录
				}
				
				try{
					file.transferTo(targetFile);
				}catch(Exception e){
					return new JsonResult<UserEntity>(e.getMessage());
				}
				
				user.setHead("/users/head/" + newFileName);
				System.out.println("头像路径：" + request.getSession().getServletContext().getRealPath("uploadFloder/users/head/") + newFileName);
			}
			
			System.out.println("注册的账号是：" + user);
			userService.addUser(user);
			System.out.println("register success.");
			return new JsonResult<UserEntity>(0, "注册成功", null, null);
		}catch(Exception e){
			return new JsonResult<UserEntity>(e.toString());
		}
	}
	
	
}
