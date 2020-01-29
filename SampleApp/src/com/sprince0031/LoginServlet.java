package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        boolean loggedin = false;
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        String usernameToCompare = "sprince0031";
        String passwordToCompare = "p@ssw0rD";

        if (user.equals(usernameToCompare) && pass.equals(passwordToCompare)) {
            loggedin = true;
        }        

    }
}