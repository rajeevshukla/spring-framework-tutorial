package com.spring.jwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.spring.jwt.exception.JwtTokenMissingException;
import com.spring.jwt.model.JwtAuthToken;

public class JwtAuthenticationTokenFilter  extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationTokenFilter() {
		super("/rest/*");
	}

	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		return true;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
			
		System.out.println("== Attempting authentication ");
		//this is the place where we are going to decode the jwt token
		String header = request.getHeader("authorization");

		if(header == null || !header.startsWith("Bearer")) {
			System.out.println("Throwing exception.... as jwt token is missing.");
			throw new JwtTokenMissingException("Jwt token is missing in the request");
		}

		String token = header.substring(7);

		JwtAuthToken authToken = new JwtAuthToken();
		authToken.setToken(token);
         System.out.println("Going to authenticate" +authToken);
		 return getAuthenticationManager().authenticate(authToken);

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
      
      //Here you can add auth token in response..  
		
		
        logger.info("Authenticate user successfully");
       /* UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserAuthentication userAuthentication = new UserAuthentication(userDetails);
        userAuthentication.setAuthenticated(true);

        // Add the token to the HTTP response header
        tokenAuthenticationService.addTokenToResponse(userAuthentication, response);

        // Add the userAuthentication to the Security context
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
		
		*/
		
		System.out.println("authentication success ===");
		chain.doFilter(request, response);

	}

}
