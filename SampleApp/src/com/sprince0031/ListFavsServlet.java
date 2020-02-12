package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sprince0031.DBConnection;

public class ListFavsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        try {
            Connection connection = new DBConnection().getConnection();
            String sql = "SELECT username, favjokes FROM joketracker WHERE username=?";
            PreparedStatement prepStatment = connection.prepareStatement(sql);
            prepStatment.setString(1, username);
            ResultSet resultSet = prepStatment.executeQuery();
            System.out.println("SELECT executed");
            if(resultSet.next()) {
                System.out.println("resultset returned value");
                Array arr = resultSet.getArray("favjokes");
                String[] arrIntermediate = {};
                try {
                    arrIntermediate = (String[])arr.getArray();
                } catch(Exception e) {
                    // e.printStackTrace();
                }
                // out.print(arrToReturn);
                List<String> arrToReturn = new ArrayList<String>();
                Collections.addAll(arrToReturn, arrIntermediate);
                String json = new Gson().toJson(arrToReturn);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.write(json);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
}