package com.spring.jwt.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.jwt.security.JWTAuthenticationProvider;
import com.spring.jwt.security.JwtAuthenticationEntryPoint;
import com.spring.jwt.security.JwtAuthenticationSuccessHandler;
import com.spring.jwt.security.JwtAuthenticationTokenFilter;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
     
	@Autowired
	JWTAuthenticationProvider authenticationProvider;
	
	@Autowired 
	JwtAuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter() {

		JwtAuthenticationTokenFilter authenticationTokenFilter =
				new JwtAuthenticationTokenFilter();
		authenticationTokenFilter.setAuthenticationManager(authenticationManager());
		authenticationTokenFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		return authenticationTokenFilter;
	}


	@Bean 
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*http.csrf().disable().authorizeRequests().antMatchers("****").authenticated()
		.and()*/
		
		System.out.println("Configuing Security...");
		http	
			.csrf().disable()
			.headers().cacheControl().disable().and()
			.authorizeRequests()
			
			// allow
			.antMatchers("/js/**","/lib/**","/template/**").permitAll()
			
			.antMatchers(HttpMethod.GET,"/","index.html").permitAll().
			
			antMatchers(HttpMethod.POST,"/api/login","api/signup").permitAll()
			.and().formLogin().loginPage("/api/login").permitAll();
			
			
			/*.and().formLogin().loginPage("/api/login").successHandler(authenticationSuccessHandler).and()
			
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			
			.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
			*/
//			.and().addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}

	// to add any static in memory username and password
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
          .withUser("temporary").password("temporary").roles("ADMIN")
          .and()
          .withUser("user").password("userPass").roles("USER");
	}

}
