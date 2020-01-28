package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

public class SquareServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		int sum = 0;
		
		Cookie[] cookies = req.getCookies();
		for (Cookie c: cookies) {
			if (c.getName().equals("sum")) {
				sum = Integer.parseInt(c.getValue()); 
			}
		}
		
		
//		HttpSession session = req.getSession();
//		int sum = (int) session.getAttribute("sum"); // For SendRedirect() - session management by using HttpSession object
//		int sum = Integer.parseInt(req.getParameter("sum")); // For SendRedirect() - no session management by using URL Rewriting
//		int sum = (int) req.getAttribute("sum"); // For RequestDispatcher
		out.println("<h1>The square is... </h1>" + sum*sum);
		
		ServletContext context = getServletContext();
		String cpyString = context.getInitParameter("copyright");
		out.println("<br>ServletContext: " + cpyString);
	}
}
