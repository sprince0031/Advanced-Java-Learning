package com.sprince0031;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		Cookie usernameCookie = new Cookie("user", username);
		Cookie passwordCookie = new Cookie("pass", password);
		
		res.addCookie(usernameCookie);
		res.addCookie(passwordCookie);
		
		res.sendRedirect("profile");
	}
}
