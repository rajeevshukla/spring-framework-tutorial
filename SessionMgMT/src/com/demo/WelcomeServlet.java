package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);//return session object if exists otherwise null
		if(session!=null) {
			String userName=(String)session.getAttribute("userName");
			PrintWriter printWriter=response.getWriter();

			printWriter.write("<html>");
			printWriter.write("<head>");
			printWriter.write("<title>Welcome</title>");
			printWriter.write("<body>");
			printWriter.write("<h1>Welcome "+userName+"</h1>");
			String logoutUrl = response.encodeURL("logout.htm");
			printWriter.write("<a href='" + logoutUrl +"'>Logout</a>");
			
			/*Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				printWriter.write(cookie.getName() + ":" + cookie.getValue());
				printWriter.write("<br/>");
			}*/
			printWriter.write("</body>");
			printWriter.write("</html>");
			
			

		}else {
			response.sendRedirect("login.htm");
		}
	}

}
