package com.rain.gameCommunity.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.entity.GameTypeEntity;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.SystemSupportEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.GameService;
import com.rain.gameCommunity.service.GameTypeService;
import com.rain.gameCommunity.service.SectionService;
import com.rain.gameCommunity.service.ShoppingCartService;
import com.rain.gameCommunity.service.SystemSupportService;
import com.rain.gameCommunity.service.UserService;
import com.rain.gameCommunity.utils.GetPrintSize;
import com.rain.gameCommunity.utils.JsonResult;
import com.rain.gameCommunity.utils.PagingData;

/**
 * 
 * @author wangxinyu
 *
 */

@Controller
@RequestMapping("/game")
public class GameController {
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameTypeService gameTypeService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SystemSupportService systemSupportService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	private String gameName;
	

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName
	 *            the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

//	@RequestMapping("/showallgame.do")
//	@ResponseBody
//	public JsonResult<List<GameEntity>> showAllGame() {
//		List<GameEntity> games;
//		try {
//			games = gameService.showAllGame();
//		} catch (Exception e) {
//			return new JsonResult<List<GameEntity>>(e.getMessage());
//		}
//		return new JsonResult<List<GameEntity>>(games);
//	}

	@RequestMapping("/showGame.do")
	@ResponseBody
	public JsonResult<GameEntity> showGame(String gameId) {
		GameEntity game;
		try {
			game = gameService.showGameById(gameId);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult<GameEntity>(e.getMessage());
		}
		
		return new JsonResult<GameEntity>(game, null);
	}
	
	@RequestMapping("/showAllGameType.do")
	@ResponseBody
	public JsonResult<List<GameTypeEntity>> showAllGameType(int currentPage){
		List<GameTypeEntity> gameTypes;
		PagingData pagingData = new PagingData();
		if(currentPage == 0) currentPage = 1;
		try{
			pagingData.setCurrentPage(currentPage);
			pagingData.setTotalNum(gameTypeService.queryGameTypeCount());
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			
			gameTypes = gameTypeService.showGameTypesByPage(pagingData);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<GameTypeEntity>>(e.getMessage());
		}
		return new JsonResult<List<GameTypeEntity>>(gameTypes, pagingData);
	}
	
	@RequestMapping("/showAllSystemSupport.do")
	@ResponseBody
	public JsonResult<List<SystemSupportEntity>> showAllSystemSupport(){
		try{
			return new JsonResult<List<SystemSupportEntity>>(systemSupportService.showAllSystemSupportService(), null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<SystemSupportEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/showGameByGameType.do")
	@ResponseBody
	public JsonResult<List<GameEntity>> showGameByGameType(long gameType, int currentPage){
		PagingData pagingData = new PagingData();
		try{
			pagingData.setTotalNum(gameService.showGamesCountByGameType(gameType));
			pagingData.setCurrentPage(currentPage);
			if(pagingData.getTotalNum() % pagingData.getPerPageNum() == 0){
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum());
			}else{
				pagingData.setTotalPage(pagingData.getTotalNum() / pagingData.getPerPageNum() + 1);
			}
			List<GameEntity> games = gameService.showGamesByGameType(gameType, pagingData);
			return new JsonResult<List<GameEntity>>(games, pagingData);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<GameEntity>>(e.getMessage());
		}
	}
	
	@RequestMapping("/getSectionByGameId.do")
	@ResponseBody
	public JsonResult<SectionEntity> getSectionByGameId(long gameId){
		try{
			List<SectionEntity> sections = sectionService.showSectionByGameId(gameId);
			if(sections == null || sections.size() <= 0)
				return new JsonResult<SectionEntity>(null, null);
			SectionEntity section = sections.get(0);
			return new JsonResult<SectionEntity>(section, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<SectionEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/addToShoppingCart.do")
	@ResponseBody
	public JsonResult<Boolean> addToShoppingCart(long gameId, long userId){
		try{
			//检查游戏是否已经购买
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			if(users == null || users.size() <= 0){
				throw new Exception("没有找到用户！");
			}
			UserEntity user = users.get(0);
			
			String[] games = user.getGames().split(",");
			
			for(int i = 0; i < games.length; i++){
				if(games[i].length() <= 0 || games[i].equals("")) continue;
				if(games[i].equals(gameId + "")){
					return new JsonResult<Boolean>(false, null);
				}
			}
			
			shoppingCartService.addToShoppingCart(userId, gameId);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addShoppingCartOrDownload.do")
	@ResponseBody
	public JsonResult<Boolean> addShoppingCartOrDownload(long userId, long gameId){
		try{
			List<Long> ids = new ArrayList<Long>();
			ids.add(userId);
			List<UserEntity> users = userService.queryUsersById(ids);
			if(users == null || users.size() <= 0){
				throw new Exception("没有找到用户！");
			}
			UserEntity user = users.get(0);

			String[] games = user.getGames().split(",");
			
			for(int i = 0; i < games.length; i++){
				if(games[i].length() <= 0 || games[i].equals("")) continue;
				if(games[i].equals(gameId + "")){
					return new JsonResult<Boolean>(true, null);
				}
			}
			
			return new JsonResult<Boolean>(false, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/addDownloadNum.do")
	@ResponseBody
	public JsonResult<Boolean> addDownloadNum(long gameId){
		try{
			GameEntity game = gameService.showGameById(gameId + "");
			game.setDownloadNum(game.getDownloadNum() + 1);
			gameService.updateGameEntity(game);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/showGameType.do")
	@ResponseBody
	public JsonResult<GameTypeEntity> showGameType(String gameTypeId){
		try{
			GameTypeEntity gameTypeEntity = gameTypeService.queryGameTypeById(Long.parseLong(gameTypeId));
			return new JsonResult<GameTypeEntity>(gameTypeEntity, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<GameTypeEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/showSystemSupportById.do")
	@ResponseBody
	public JsonResult<SystemSupportEntity> showSystemSupportById(long id){
		try{
			SystemSupportEntity systemSupport = systemSupportService.showSystemSupportById(id);
			if(systemSupport.getNetwork().equals("1")){
				systemSupport.setNetwork("true");
			}else if(systemSupport.getNetwork().equals("0")){
				systemSupport.setNetwork("false");
			}else{
				systemSupport.setNetwork("all");
			}
			return new JsonResult<SystemSupportEntity>(systemSupport, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<SystemSupportEntity>(e.getMessage());
		}
	}
	
	@RequestMapping("/uploadGame.do")
//	@ResponseBody
	@Transactional
	public String uploadGame(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		try{
			SystemSupportEntity systemSupport = new SystemSupportEntity();
			GameEntity game = new GameEntity();
			SectionEntity section = new SectionEntity();
			long sectionId = -1;
			
			//处理上传的游戏文件
			if(file.isEmpty()) throw new Exception("上传文件无效或者文件为空！");
			//String path = "/Users/wangxinyu/Documents/程序/GameCommunity/download/";
			String path = request.getSession().getServletContext().getRealPath("download");
			String fileName = file.getOriginalFilename(); //xxx.exe
			fileName = fileName.replaceAll(" ", "");
			path = path + "/" + request.getParameter("gameName") + "/" + request.getParameter("gameVersion") + "/";
			System.out.println(path);
			
			File targetFile = new File(path, fileName);
			if(!targetFile.exists()){
				targetFile.mkdirs();//不存在则新建目录
			}
			
			try{
				file.transferTo(targetFile);
			}catch(Exception e){
				e.printStackTrace();
				return "redirect: /gameCommunity/error.html";
			}
			
			//game.setPath(path + fileName);
			game.setPath("/gameCommunity/download/" + request.getParameter("gameName") + "/" + request.getParameter("gameVersion") + "/"
					 + fileName);
			game.setSize(GetPrintSize.getPrintSize(file.getSize()));
			
			
			
			//如果要求同时创建section，则创建section
			if(request.getParameter("createSection") == null) ;
			else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				section.setCreateTime(sdf.format(new Date()));
				section.setGameType(Long.parseLong(request.getParameter("gameTypeId")));
				section.setIntroduce(request.getParameter("sectionIntroduce"));
				section.setName(request.getParameter("sectionName"));
				section.setTopicNum(0);
				sectionService.addSection(section);
				sectionId = section.getId();
				System.out.println("加入论坛板块数据库成功！");
			}
			
			
			
			
			long systemSupportId = Long.parseLong(request.getParameter("systemSupport"));
			//用现有的系统支持
			if(systemSupportId != -1){
				game.setSystemTypeNum(systemSupportId);
			}else{
				systemSupport.setSystemName(request.getParameter("systemSupportName"));
				systemSupport.setMemoria(request.getParameter("memoria"));
				systemSupport.setDisk(request.getParameter("disk"));
				systemSupport.setDisplay(request.getParameter("display"));
				systemSupport.setNote(request.getParameter("note"));
				String network = request.getParameter("network");
				if("true".equals(network)) network = "1";
				else if("fale".equals(network)) network = "0";
				else network = "-1";
				systemSupport.setNetwork(network);
				systemSupport.setSystem(request.getParameter("system"));
				systemSupport.setCpu(request.getParameter("cpu"));
				systemSupport.setVoice(request.getParameter("voice"));
				
				//将新定义的系统支持插入数据库
				systemSupportService.addSystemSupport(systemSupport);
				game.setSystemTypeNum(systemSupport.getId());
				log.debug("加入系统支持数据库成功！");
			}
			
			game.setGameType(Long.parseLong(request.getParameter("gameTypeId")));
			game.setBuildDate(game.getSdf().format(new Date()));
			game.setVersion(request.getParameter("gameVersion"));
			game.setGameName(request.getParameter("gameName"));
			game.setPrice(Double.parseDouble(request.getParameter("gamePrice")));
			game.setIntroduce(request.getParameter("introduce"));
			if(sectionId != -1) game.setSectionId(sectionId);
			
			gameService.addGame(game);
			long gameId = game.getId();
			System.out.println("加入游戏数据库成功！");
			
			if(sectionId != -1){
				//更新论坛板块数据，将板块和游戏绑定在一起
				section.setGameId(gameId);
				sectionService.updateSection(section, sectionId);
				System.out.println("更新论坛板块数据成功！");
			}

			//return null;
			return "redirect: /gameCommunity/";
		}catch(Exception e){
			e.printStackTrace();
			//return new JsonResult<Boolean>(e.getMessage());
			return "redirect: /gameCommunity/error.html";
		}
		
	}
	
	@RequestMapping("/deleteGame.do")
	@ResponseBody
	public JsonResult<Boolean> deleteGame(long gameId){
		try{
			gameService.deleteGameByGameId(gameId);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/checkDownload.do")
	@ResponseBody
	public JsonResult<Boolean> checkDownload(HttpSession session, long gameId, long userId){
		try{
			
			UserEntity user = userService.showUserByUserId(userId);
			if(user == null){
				throw new Exception("用户不存在!");
			}
			String games = user.getGames();
			if(games == null || games.length() <= 0){
				return new JsonResult<Boolean>(false, null);
			}
			games.replaceAll(" ", "");
			String[] checkGames = games.split(",");
			for(int i = 0; i < checkGames.length; i++){
				if(checkGames[i].equals(gameId + "")){
					return new JsonResult<Boolean>(true, null);
				}
			}
			return new JsonResult<Boolean>(false, null);
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/modifyCutOff")
	@ResponseBody
	public JsonResult<Boolean> modifyCutOff(long gameId, double cutOff){
		try{
			GameEntity game = gameService.showGameById(gameId+"");
			game.setCutOff(cutOff);
			gameService.updateGameEntity(game);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
	
	@RequestMapping("/modifyPrice")
	@ResponseBody
	public JsonResult<Boolean> modifyPrice(long gameId, double price){
		try{
			GameEntity game = gameService.showGameById(gameId+"");
			game.setPrice(price);
			gameService.updateGameEntity(game);
			return new JsonResult<Boolean>(true, null);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Boolean>(e.getMessage());
		}
	}
}
