package com.hospital.hospitaldemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.inMemoryAuthentication().withUser("amay").password("{noop}bhatnagar").roles("USER").and().withUser("admin")
		.password("{noop}admin").roles("USER", "ADMIN");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		super.configure(http);
		http.csrf().disable();
	}

}
