package com.spring.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.spring.jwt.exception.JwtMalformException;
import com.spring.jwt.model.JwtAuthToken;
import com.spring.jwt.model.JwtUser;
import com.spring.jwt.model.JwtUserDetails;
import com.spring.jwt.utils.JwtUtils;
@Component
public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	JwtUtils jwtUtils;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		 //aut
		System.out.println( "Inside authentication"+authentication);
		System.out.println("Authenticating user ");
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return JwtAuthToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// to take care of any additional authentication checks if needed. 
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		System.out.println("Retriving User details for Username :"+ username);
		JwtAuthToken authToken =(JwtAuthToken) authentication;
		  
		  JwtUser jwtUser =  jwtUtils.parseToken(authToken.getToken());
		  
		  
		  if(jwtUser == null) {
			  throw new JwtMalformException("Invalid jwt token");
		  }
		  
		  
		  JwtUserDetails userDetails = new JwtUserDetails(jwtUser.getUserId(),
				  jwtUser.getUsername(), authToken.getToken(),
				  AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole()));

		  return userDetails;
	}
	
	
	

}
