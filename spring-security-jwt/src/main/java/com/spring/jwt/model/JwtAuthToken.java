package com.spring.jwt.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -6125437139046562085L;
	
	private String token;
	
	public JwtAuthToken() {
		super(null, null);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtAuthToken [token=" + token + "]";
	}
}
