package com.yes2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyAccount() {
		System.out.println(getClass() + ": Doing Stuff: Adding A membership account");

		return true;

	}

	public void gotToSleep() {

		System.out.println(getClass() + ": I am going to sleep now ....");

	}

}
