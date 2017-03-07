//package com.rain.gameCommunity;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.rain.gameCommunity.entity.GameEntity;
//import com.rain.gameCommunity.service.impl.GameServiceImpl;
//
//public class GameEntityTest {
//
//	private ApplicationContext ac;
//	private GameServiceImpl gs;
//
//	@Test
//	public void test1() throws Exception {
//		ac = new ClassPathXmlApplicationContext("root-context.xml", "service-context.xml");
//		gs = ac.getBean("gameServiceImpl", GameServiceImpl.class);
//		GameEntity game = new GameEntity();
//		game = gs.showGame("饥荒");
//		System.out.println(game);
//	}
//}
