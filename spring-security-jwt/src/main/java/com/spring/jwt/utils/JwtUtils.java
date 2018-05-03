package com.spring.jwt.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.jwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	@Value("${jwt.secret}")
	private String secret;

	public JwtUser parseToken(String token) {

		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		JwtUser jwtUser = new JwtUser();
		jwtUser.setUsername(body.getSubject());
		jwtUser.setUserId((String) body.get("userId"));
		jwtUser.setRole((String) body.get("role"));

		return jwtUser;
	}

	public String generateToken(JwtUser jwtUser) {
		
		Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
		claims.put("id", jwtUser.getUserId());
		claims.put("role", jwtUser.getRole());

		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secret).compact();

		return token;
	}
}
