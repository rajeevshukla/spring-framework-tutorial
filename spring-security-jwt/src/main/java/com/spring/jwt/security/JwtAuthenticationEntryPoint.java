package com.spring.jwt.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint{
  
	
	// to throw Error To user in case of user is not authenticated.
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
	
		 System.out.println("Authentication error...");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unautherized");
	}

}
