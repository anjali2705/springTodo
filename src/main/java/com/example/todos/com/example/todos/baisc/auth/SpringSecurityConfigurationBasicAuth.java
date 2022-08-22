package com.example.todos.com.example.todos.baisc.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**")
		.permitAll().anyRequest().authenticated().and().httpBasic();
		
	
		
//		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
//	    http.antMatcher("/**").permitAll();
//		//http.formLogin();
//		http.httpBasic();
	}
}
