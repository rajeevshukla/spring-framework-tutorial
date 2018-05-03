package com.globallogic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("login.htm")
	public String welcome() {
		System.out.println("Again login..");
		return "login";
	}
	
	@GetMapping("admin.htm")
	public String admin() {
		return "admin";  ///web-inf/jsp/admin.jsp
	}
	
	
	@GetMapping("home.htm") 
	public String home() {
		return "home";
	}
	
	
}
