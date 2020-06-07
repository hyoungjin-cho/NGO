package com.summitworks.ngo.authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
//   @Autowired
//   MyDBAuthenticationService myDBAauthenticationService;
// 
//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// 
//       // For User in database.
//       auth.userDetailsService(myDBAauthenticationService);
// 
//   }
 
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
// 
//       http.csrf().disable();
// 
//       // The pages requires login as EMPLOYEE or MANAGER.
//       // If no login, it will redirect to /login page.
//       http.authorizeRequests().antMatchers("/orderList","/order", "/accountInfo")//
//               .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");
// 
//       // For MANAGER only.
//       http.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");
// 
//       // When the user has logged in as XX.
//       // But access a page that requires role YY,
//       // AccessDeniedException will throw.
//       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
// 
//       // Config for Login Form
//       http.authorizeRequests().and().formLogin()//
//               // Submit URL of login page.
//               .loginProcessingUrl("/j_spring_security_check") // Submit URL
//               .loginPage("/login")//
//               .defaultSuccessUrl("/accountInfo")//
//               .failureUrl("/login?error=true")//
//               .usernameParameter("userName")//
//               .passwordParameter("password")
//               // Config for Logout Page
//               // (Go to home page).
//               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
// 
//   }
//   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	
}