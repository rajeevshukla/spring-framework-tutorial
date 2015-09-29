package com.demo;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateLoginServlet extends HttpServlet {
	
 private static	HashMap<String, String> userNamePasswordMap=new HashMap<String, String>();
	
    static {
    	userNamePasswordMap.put("user1", "password1");
    	userNamePasswordMap.put("user2", "password2");
    	userNamePasswordMap.put("user3", "password3");
    	userNamePasswordMap.put("user4", "password4");
    	userNamePasswordMap.put("user5", "password5");
    }
	
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		 System.out.println("user name "+userName);

		 if( userName ==null) {
			 response.sendRedirect("loginError.html");
			 return ;
		 }
		 
		 if(userNamePasswordMap.containsKey(userName) && userNamePasswordMap.containsValue(password)) {
			 HttpSession session=request.getSession();//or request.getSession(); if session does not exists then automatically created.
			 //session.getAttributeNames();
			 /*
			 session.invalidate();
			 session = request.getSession();*/
			 
			 
			 session.setAttribute("userName",userName);
			 //session.setMaxInactiveInterval(30*1000);
			 Cookie cookie=new Cookie("color", "red");
			 cookie.setHttpOnly(true);
			 cookie.setMaxAge(10);
			 cookie.setSecure(true);
			 response.addCookie(cookie);
			 //			 response.sendRedirect("welcome.htm"); //redirecting to different url.
			 
			 request.getRequestDispatcher("welcome.htm").forward(request, response);

			 //response.sendRedirect(response.encodeRedirectURL("welcome.htm"));
			 
		 }else {
			 response.sendRedirect("loginError.html");
			 
		 }
		 
	}

}
