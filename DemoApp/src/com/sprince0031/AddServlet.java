package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    	PrintWriter out = res.getWriter();
    	int i = Integer.parseInt(req.getParameter("num1"));
    	int j = Integer.parseInt(req.getParameter("num2"));
    	out.println("<h1>The answer is...</h1>");
    	out.println(i + j);
    }
}
