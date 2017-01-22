package com.rain.gameCommunity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rain.gameCommunity.service.impl.UserServiceImpl;

public class UserEntityTest {

	private ApplicationContext ac;
	private UserServiceImpl us;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("root-context.xml", "service-context.xml");
		us = ac.getBean("userServiceImpl", UserServiceImpl.class);
	}

	@Test
	public void test() throws Exception {
		System.out.println(us.showAllUsers());
	}

}
