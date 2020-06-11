package com.summitworks.ngo.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/registration/{event_id}", 
				"/registration/next","/events/detail/{id}",
				"/registration/confirm", "/registration/", "/", 
				"/users/login")
				.access("hasAnyRole('ROLE_Admin', 'ROLE_Regular')");
//
//		// For ADMIN only.
		http.authorizeRequests()
				.antMatchers("/events/management", 
						"/events/add", "/events/edit/{id}", "/events/delete/{id}",
						 "/users/management", "/users/add",
						"/users/edit/{id}", "/users/delete/{id}", "/users/home")
				.access("hasRole('ROLE_Admin')");

		http.authorizeRequests().antMatchers("/addUser", "/save").permitAll().anyRequest().authenticated().and()
				.formLogin().loginProcessingUrl("/login") // Submit URL
				.loginPage("/users/login").permitAll().and().logout().permitAll().and().csrf().disable();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyDBAuthenticationService();
	};

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

}