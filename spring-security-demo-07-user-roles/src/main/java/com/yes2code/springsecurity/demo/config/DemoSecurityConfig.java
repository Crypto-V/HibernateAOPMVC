package com.yes2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("John").password("test123").roles("Employee"));
		auth.inMemoryAuthentication()
				.withUser(users.username("Vasile").password("test123").roles("Employee", "Manager"));
		auth.inMemoryAuthentication()
				.withUser(users.username("Peter").password("test123").roles("Employee", "Manager", "Administrator"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Configure the web path for incoming requests
		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("Employee", "Manager", "Administrator")
		.antMatchers("/leaders/**").hasAnyRole("Manager", "Administrator")
		.antMatchers("/systems/**").hasRole("Administrator")
		.and().formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser").permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");

	}

}
