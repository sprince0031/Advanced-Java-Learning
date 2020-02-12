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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sprince0031.DBConnection;

public class FavToggleServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        Boolean loggedIn = (Boolean)session.getAttribute("loggedin");
        // Integer id = Integer.parseInt(request.getParameter("id"));
        // String setup = request.getParameter("setup");
        // String punchline = request.getParameter("punchline");
        String joke = request.getParameter("joke");
        Boolean favFlag = Boolean.parseBoolean(request.getParameter("favFlag"));
        System.out.println("fav servlet called...");
        if (loggedIn) {
            System.out.println("Logged in.");
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
                    
                    ArrayList<String> arrToManipulate = new ArrayList<String>();
                    Collections.addAll(arrToManipulate, arrIntermediate);
                    // String data = id + "%%" + setup + "%%" + punchline;
                    if (favFlag) {
                        arrToManipulate.add(jokeJson);
                    } else {
                        arrToManipulate.remove(jokeJson);
                    }

                    arr = connection.createArrayOf("text", arrToManipulate.toArray());
                    sql = "UPDATE joketracker SET favjokes=?::JSON WHERE username=?";
                    prepStatment = connection.prepareStatement(sql);
                    prepStatment.setObject(1, arr);
                    prepStatment.setString(2, username);
                    prepStatment.executeUpdate();
                    connection.close();

                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        } else {
            System.out.println("Not logged in...");
        }

        out.print("Joke: " + jokeJson + ", favFlag: " + favFlag);
    }
}