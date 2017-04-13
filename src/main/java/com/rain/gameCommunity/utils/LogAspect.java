package com.rain.gameCommunity.utils;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author wangxinyu
 *
 */
@Aspect
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	// 用户名
	private String username = null;
	
	// 传入参数
	private Map<?,?> inputParamMap = null ;   
	
	// 存放输出结果 
    private Map<String, Object> outputParamMap = null;  
    
    // 开始时间
    private long startTimeMillis = 0;   
    
    // 结束时间
    private long endTimeMillis = 0;  
    
    @Before("execution (* com.rain.gameCommunity.controller..*.*(..))")
    public void doBefore(){
    		log.debug("------------------------------------------------");
    		log.debug("开始执行");
    		startTimeMillis = System.currentTimeMillis();
    }
    
    @After("execution (* com.rain.gameCommunity.controller..*.*(..))")
    public void doAfter(){
    		endTimeMillis = System.currentTimeMillis();
    		log.debug("执行完成！");
    		log.debug("------------------------------------------------");
    }
    
    @Around("execution (* com.rain.gameCommunity.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
    	
    		log.debug(pjp.getThis().getClass().getName());
    		log.debug("方法{}正在执行……,参数为：{}", pjp.getSignature().getName(), pjp.getArgs());
    		
    		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        outputParamMap = new HashMap<String, Object>();  
        Object result = pjp.proceed();// result的值就是被拦截方法的返回值
        outputParamMap.put("result", result);  
        log.debug(outputParamMap.toString());
        return result;  
    }
    
}
