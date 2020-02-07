package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    public boolean register(String user, String pass) throws SQLException {

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
                
                connection.close();
                return true;
            }
        }
        connection.close();
        return false;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        // String pass = request.getParameter("re-pass");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phnumber");
  
        HttpSession session = request.getSession();
        // System.out.println("<br><br><br><br><br>before authenticating...");
        try {
            if (register(user, pass)) {
                System.out.println("<br><br><br><br><br>Successfully authenticated!");
                session.setAttribute("loggedin", true);
                session.setAttribute("username", user);
                session.setAttribute("link", "profile.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
                rd.forward(request, response);
    
            } else {
                out.println("<br><br><br><br><br><p style=\"color:#e00;font-size:3em;\">Sorry! Invalide username or password.</p>");
                System.out.println("<br><br><br><br><br>Aunthentication failed!");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException se) {
            out.println(se.getMessage() + "<br><br>");
            for (StackTraceElement trace: se.getStackTrace())
            out.println(trace);
        }
    }
}
