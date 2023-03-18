package com.yes2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yes2code.aopdemo.dao.AccountDAO;
import com.yes2code.aopdemo.dao.MembershipDAO;
import com.yes2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theForutneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		

		System.out.println("\n Main Program: AroundDemoApp");
		
		System.out.println(" Calling getFortune");
		String data = theForutneService.getFortune();
		System.out.println("My fortune is "+data);
		System.out.println("\nFinished!!!");

		
		// close the context
		context.close();
	}

}










