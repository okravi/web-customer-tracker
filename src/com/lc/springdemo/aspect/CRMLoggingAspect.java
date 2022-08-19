package com.lc.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg : args) {
			myLogger.info("\\n ===> in @Before, arg: " + arg );
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display the method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ===> in @AfterReturning from method: " + theMethod);
		
		//display the data returned
		myLogger.info("\\n ===> result: " + theResult );

		
	}
}
