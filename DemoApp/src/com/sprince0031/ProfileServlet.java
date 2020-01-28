package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		String passwordToCompare = "p@ssw0rD";
		String usernameToCompare = "sprince0031";
		boolean userFlag = false, passFlag = false;
		String message = "";
		String user = "";
		
		for (Cookie c: cookies) {
			if (c.getName().equals("user") && c.getValue().equals(usernameToCompare)) {
				userFlag = true;
				user = c.getValue();
				System.out.println("Got +ve hit on username: " + c.getValue());
			} else if (c.getName().equals("pass") && c.getValue().equals(passwordToCompare)) {
				passFlag = true;
				System.out.println("Got +ve hit on password: " + c.getValue());
			} else {
				System.out.println("Nope: " + c.getName() + ": "  + c.getValue());
				message = "Wrong username or password.";
			}
			
			if (userFlag && passFlag) {
				message = "Welcome " + user + "!";
				break;
			}
			
			
		}
		
		out.println("<h1>"+message+"</h1>");
		
		// Servlet context & Config
		ServletConfig config = getServletConfig();
		String copyrightStr = config.getInitParameter("copyright");
		out.println("ServletConfig: " + copyrightStr);
		
		
	}
}
