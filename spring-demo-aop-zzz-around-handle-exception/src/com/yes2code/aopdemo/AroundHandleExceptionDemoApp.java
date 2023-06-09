package com.yes2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yes2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theForutneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\n Main Program: AroundDemoApp");

		myLogger.info(" Calling getFortune");

		boolean tripWire = true;
		String data = theForutneService.getFortune(tripWire);
		
		myLogger.info("My fortune is " + data);
		myLogger.info("\nFinished!!!");

		// close the context
		context.close();
	}

}
