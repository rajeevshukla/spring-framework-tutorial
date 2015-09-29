package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		
		getServletContext().getInitParameter("asdfa");
		
		PrintWriter printWriter=response.getWriter();
		printWriter.write("<html>");
		printWriter.write("<head>");
		printWriter.write("<title>Login Page </title>");
		printWriter.write("<body>");
		printWriter.write("<h1> Logout successfully ! </h1>");
		printWriter.write("<a href='login.htm'>Login Again ?</a>");
		
	}

}
