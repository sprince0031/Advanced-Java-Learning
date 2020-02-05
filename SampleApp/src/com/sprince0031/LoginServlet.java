package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sprince0031.DBConnection;

public class LoginServlet extends HttpServlet {

    public boolean authenticate(String user, String pass) throws SQLException {

        Connection connection = new DBConnection().getConnection();
        String sqlStatement = "SELECT username, pass FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sqlStatement);
        statement.setString(1, user);
        System.out.println("<br><br><br><br><br>somethingfailed-1");
        ResultSet resultSet = statement.executeQuery();
        System.out.println("<br><br><br><br><br>somethingfailed-2");
        while(resultSet.next()) {
            System.out.println("username: " + resultSet.getString("username") + ", password: " + resultSet.getString("pass"));
            if (user.equals(resultSet.getString("username")) && pass.equals(resultSet.getString("pass"))) {
                
                return true;
            }
        }
        return false;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        
        HttpSession session = request.getSession();
        System.out.println("<br><br><br><br><br>before authenticating...");
        try {
            if (authenticate(user, pass)) {
                System.out.println("<br><br><br><br><br>Successfully authenticated!");
                session.setAttribute("loggedin", true);
                session.setAttribute("username", user);
                session.setAttribute("link", "profile.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
                rd.forward(request, response);
    
            } else {
                // response.sendRedirect("login");
                // session.setAttribute("loggedin", false);
                // session.setAttribute("username", "Login");
                out.println("<br><br><br><br><br><p style=\"color:#e00;font-size:3em;\">Sorry! Invalide username or password.</p>");
                System.out.println("<br><br><br><br><br>Aunthentication failed!");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException se) {
            out.println(se.getMessage() + "<br><br>");
            for (StackTraceElement trace: se.getStackTrace())
            out.println(trace);
            // out.println(user.equals(resultSet.getString(1)) && pass.equals(resultSet.getString(2)));
        }

        
        
        // String usernameToCompare = "sprince0031";
        // String passwordToCompare = "p@ssw0rD";
        
    }
}