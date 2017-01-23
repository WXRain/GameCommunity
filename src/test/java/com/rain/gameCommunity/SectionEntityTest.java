package com.rain.gameCommunity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rain.gameCommunity.service.impl.SectionServiceImpl;

public class SectionEntityTest {

	private ApplicationContext ac;
	private SectionServiceImpl ss;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("root-context.xml", "service-context.xml");
		ss = ac.getBean("sectionServiceImpl", SectionServiceImpl.class);
	}

	@Test
	public void test() throws Exception {
		System.out.println(ss.showAllSection());
	}

}
