package com.rain.gameCommunity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rain.gameCommunity.entity.GameEntity;
import com.rain.gameCommunity.service.impl.GameServiceImpl;

public class GameEntityTest {

	private ApplicationContext ac;
	private GameServiceImpl gs;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("root-context.xml", "service-context.xml");
		gs = ac.getBean("gameServiceImpl", GameServiceImpl.class);
	}

	@Test
	public void test1() {
		List<GameEntity> games = new ArrayList<GameEntity>();
		games = gs.showAllGame();
		System.out.println(games);
	}
}
