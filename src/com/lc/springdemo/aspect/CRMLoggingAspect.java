package com.lc.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution (* com.lc.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution (* com.lc.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution (* com.lc.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//combined poincut decl
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}

	//add @Before advice
	@Before("forAppFlow()")
	public void before (JoinPoint theJoinPoint) {
		
		//display the method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ===> in @Before - calling method: " + theMethod);
		//display the arguments
		
	}
	
	//add @AfterReturning advice
}
