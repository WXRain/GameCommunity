package com.rain.gameCommunity.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rain.gameCommunity.entity.OrderEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.UserService;
import com.rain.gameCommunity.utils.JsonResult;

/**
 * 
 * @author wangxinyu
 *
 */

@Controller
@RequestMapping("/user")
public class UserCotroller {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService;

	@RequestMapping("/checkUser.do")
	@ResponseBody
	public JsonResult<UserEntity> checkUser(String username, String password){
		UserEntity user;
		try {
			user = userService.checkUser(username, password);
		} catch (Exception e) {
			return new JsonResult<UserEntity>(e.getMessage());
		}
		return new JsonResult<UserEntity>(user, null);
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
			e.printStackTrace();
			return new JsonResult<UserEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/registerUser.do")
	//@ResponseBody
	public String registerUser(
			MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
		UserEntity user = new UserEntity();	
		try{
			System.out.println("注册账号中……");
			user.setUsername(request.getParameter("username"));
			user.setPasswords(request.getParameter("passwords"));
			user.setSex(Integer.parseInt(request.getParameter("sex")));
			user.setIntroduce(request.getParameter("introduce"));
			user.setRegisterTime(new Date());
			
			if(!file.isEmpty()){
				//处理头像
//				String path = request.getSession().getServletContext().getRealPath("uploadFloder/users/head");
				String path = request.getSession().getServletContext().getRealPath("img/user/head");
				String filename = file.getOriginalFilename();//xxx.jpg
				System.out.println(filename);
				String[] names = filename.split("\\.");
				String newFileName = user.getRegisterTime().getTime() + "." + names[names.length-1];
				
				File targetFile = new File(path, newFileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();//不存在则新建目录
				}
				
				try{
					file.transferTo(targetFile);
				}catch(Exception e){
					//return new JsonResult<UserEntity>(e.getMessage());
					return "redirect: /gameCommunity/error.html";
				}
				
				user.setHead("/img/user/head/" + newFileName);
//				System.out.println("头像路径：" + request.getSession().getServletContext().getRealPath("uploadFloder/users/head/") + newFileName);
				System.out.println("头像路径：" + request.getSession().getServletContext().getRealPath("img/user/head/") + newFileName);

			}
			
			System.out.println("注册的账号是：" + user);
			userService.addUser(user);
			System.out.println("register success.");
			//return new JsonResult<UserEntity>(0, "注册成功", null, null);
			return "redirect: /gameCommunity/";
		}catch(Exception e){
			//return new JsonResult<UserEntity>(e.toString());
			e.printStackTrace();
			request.getSession().setAttribute("errorMessage", e.getMessage());
			return "redirect: /gameCommunity/error.html";
		}
	}
	
	@RequestMapping("/findUserByUserId.do")
	@ResponseBody
	public JsonResult<UserEntity> findUserByUserId(long userId){
		try{
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			UserEntity user;
			if(users != null && users.size() > 0){
				user = users.get(0);
			}else throw new Exception("没有找到用户！");
			user = gameService.showUserGameByUser(user);
			user.setRegisterTimeString(user.getSdf().format(user.getRegisterTime()));
			return new JsonResult<UserEntity>(user, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<UserEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/modifyUser.do")
	@ResponseBody
	public JsonResult<Boolean> modifyUser(long userId, String username, String oldPassword, String passwords,
			int sex, String introduce){
		try{
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			UserEntity user;
			if(users != null && users.size() > 0){
				user = users.get(0);
			}else throw new Exception("没有找到用户！");
			
			if(!user.getPasswords().equals(oldPassword)) throw new Exception("原密码不正确！");
			
			user.setUsername(username);
			user.setPasswords(passwords);
			user.setSex(sex);
			user.setIntroduce(introduce);
			
			userService.modifyUser(user);
			return new JsonResult<Boolean>(true, null);
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/modifyUserHead.do")
	public String modifyUserHead(
			MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		try{
			
			long userId = Long.parseLong(request.getParameter("userId"));
			System.out.println(userId);
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			UserEntity user;
			if(users != null && users.size() > 0){
				user = users.get(0);
			}else throw new Exception("没有找到用户！");
			
			if(!file.isEmpty()){
				//处理头像
//				String path = request.getSession().getServletContext().getRealPath("uploadFloder/users/head");
				String path = request.getSession().getServletContext().getRealPath("img/user/head");
				String filename = file.getOriginalFilename();//xxx.jpg
				System.out.println(filename);
				String[] names = filename.split("\\.");
				String newFileName = new Date().getTime() + "." + names[names.length-1];
				
				File targetFile = new File(path, newFileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();//不存在则新建目录
				}
				
				try{
					file.transferTo(targetFile);
				}catch(Exception e){
					//return new JsonResult<UserEntity>(e.getMessage());
					return "redirect: /gameCommunity/error.html";
				}
				
				user.setHead("/img/user/head/" + newFileName);
//				System.out.println("头像路径：" + request.getSession().getServletContext().getRealPath("uploadFloder/users/head/") + newFileName);
				System.out.println("头像路径：" + request.getSession().getServletContext().getRealPath("img/user/head/") + newFileName);
			}
			
			userService.modifyUser(user);
			
			return "redirect: /gameCommunity/user/showUser.html?userId=" + userId;
			
		}catch(Exception e){
			e.printStackTrace();
			return "redirect: /gameCommunity/error.html";
		}
	}
	
	@RequestMapping("/showOrdersByUserId.do")
	@ResponseBody
	public JsonResult<List<OrderEntity>> showOrdersByUserId(long userId){
		try{
			List<OrderEntity> orders = userService.showOrdersByUserId(userId);
			return new JsonResult<List<OrderEntity>>(orders, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<OrderEntity>>(e.getMessage());
		}
	}
	
}
