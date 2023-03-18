package com.yes2code.springdemo.aspect;

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

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations controller* any class * any method * any number
	// of
	// arguments
	@Pointcut("execution(* com.yes2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// setup pointcut declarations service * any class * any method * any number of
	// arguments
	@Pointcut("execution(* com.yes2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	// setup pointcut declarations dao * any class * any method * any number of
	// arguments
	@Pointcut("execution(* com.yes2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// Combine all pointcuts together
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice, joinpoint gives the metadata about method call
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		// display method we call
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @Before: calling method: " + theMethod);

		// display the argumets to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop thru and display arguments
		for (Object tempArg : args)
			myLogger.info("====> This is argument:  " + args);
	}

	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult")//theResult from returning points to the method attribute
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		
		//display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @AfterReturning: calling method: " + theMethod);
		
		
		//display the data returned
		myLogger.info("====> This is a returned data:  " + theResult);
	}

}
