package com.globallogic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.globallogic.dao.UserDetailsServiceImpl;
import com.globallogic.security.CustomerAuthFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired 
	CustomerAuthFailureHandler authFailureHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}
	
	/*@Bean
	public AuthenticationProvider  authProvider() {
			DaoAuthenticationProvider authenticationProvider = new
					DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authentiationManager() {
		return new ProviderManager(Arrays.asList(authProvider()));
	}
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().
		antMatchers("/js/*").permitAll().antMatchers("/index.html").permitAll().antMatchers("/admin/**").
		hasRole("ADMIN").anyRequest().authenticated().and().
		formLogin().loginPage("/login.htm").permitAll().defaultSuccessUrl("/home.htm",true).
		failureHandler(new SimpleUrlAuthenticationFailureHandler()).and().
		logout();
	
	}
	
}
