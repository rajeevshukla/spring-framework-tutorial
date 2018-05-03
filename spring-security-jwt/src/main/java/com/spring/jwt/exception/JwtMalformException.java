package com.spring.jwt.exception;

import org.springframework.security.core.AuthenticationException;

public class JwtMalformException extends AuthenticationException {

	public JwtMalformException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 3923778404208494314L;

	
}
