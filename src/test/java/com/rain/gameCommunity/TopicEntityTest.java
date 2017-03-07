//package com.rain.gameCommunity;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.rain.gameCommunity.service.impl.TopicServiceImpl;
//
//public class TopicEntityTest {
//
//	private ApplicationContext ac;
//	private TopicServiceImpl ts;
//
//	public void init() {
//		ac = new ClassPathXmlApplicationContext("root-context.xml", "service-context.xml");
//		ts = ac.getBean("topicServiceImpl", TopicServiceImpl.class);
//	}
//
//	@Test
//	public void test() throws Exception {
//		System.out.println(ts.showAllTopic());
//	}
//
//}
