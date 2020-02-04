package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        String usernameToCompare = "sprince0031";
        String passwordToCompare = "p@ssw0rD";
        HttpSession session = request.getSession();
        if (user.equals(usernameToCompare) && pass.equals(passwordToCompare)) {
            session.setAttribute("loggedin", true);
            session.setAttribute("username", user);
            session.setAttribute("link", "profile.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
            rd.forward(request, response);

        } else {
            out.println("<br><br><br><p style=\"color:#e00;font-size:3em;\">Sorry! Invalide username or password.</p>");
            // response.sendRedirect("login");
            // session.setAttribute("loggedin", false);
            // session.setAttribute("username", "Login");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }
}