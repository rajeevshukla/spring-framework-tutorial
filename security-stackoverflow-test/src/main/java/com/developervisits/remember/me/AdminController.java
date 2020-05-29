package com.developervisits.remember.me;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	@GetMapping("/loginSuccess")
	public String showAdmin(@AuthenticationPrincipal User userDetails) {
		// check the role if user then redirect to user page, if admin then redirect to admin page. 
		List<GrantedAuthority> authorties = userDetails.getAuthorities().stream().collect(Collectors.toList());

		boolean isAdmin=false;
		if(authorties.stream().anyMatch(p->p.getAuthority().equals("ROLE_ADMIN"))) {
			return "admin/index";
		} else {
			return "user/index";
		}
	}
}