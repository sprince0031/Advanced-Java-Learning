package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("hello there!");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        // String pass = request.getParameter("re-pass");
        String email = request.getParameter("email");
        String dobToParse = request.getParameter("dob");
        System.out.println(dobToParse);
        Date dob = null;
        try {
            dob = new SimpleDateFormat("dd-mm-yyyy").parse(dobToParse);
        } catch(ParseException pe) {
            pe.printStackTrace();
        }
        
        int phone = Integer.parseInt(request.getParameter("phnumber"));

        try {
            Connection connection = new DBConnection().getConnection();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS userdata (id SERIAL PRIMARY KEY, username VARCHAR NOT NULL, email VARCHAR NOT NULL, dob DATE NOT NULL, phone INT NOT NULL)");
            String prepSQLUserData = "INSERT INTO userdata (username, email, dob, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(prepSQLUserData);
            prepStatement.setString(1, user);
            prepStatement.setString(2, email);
            prepStatement.setDate(3, new java.sql.Date(dob.getTime()));
            prepStatement.setInt(4, phone);
            prepStatement.executeUpdate();
            String prepSQLuser = "INSERT INTO users (username, password) VALUES (?, ?)";
            prepStatement = connection.prepareStatement(prepSQLuser);
            prepStatement.setString(1, user);
            prepStatement.setString(2, pass);
            prepStatement.executeUpdate();
            HttpSession session = request.getSession();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
