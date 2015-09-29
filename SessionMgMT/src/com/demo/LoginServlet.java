package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String value = config.getInitParameter("key1");
		System.out.println("Init Value " + value);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		/*ServletContext context = request.getServletContext();
		String value1 = context.getInitParameter("param1");
		*/
		PrintWriter printWriter=response.getWriter();
		printWriter.write("<html>");
		printWriter.write("<head>");
		printWriter.write("<title>Login Page </title></head>");
		printWriter.write("<body>");
		printWriter.write("<form action='validateLogin.htm' method='post'>");
		printWriter.write("User Name <input type='text' name='userName'> <br>");
		printWriter.write("Password <input type='password' name='password'><br>");
		printWriter.write("<input type='submit' value='Login'>");
		printWriter.write("</body>");
		printWriter.write("</html>");
		printWriter.flush();
		
	}

}
