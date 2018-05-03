package com.spring.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.utils.JwtUtils;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("login")
	public String login() {
			System.out.println("I can access this url");
		return jwtUtils.generateToken(null);
	}
	

}
