package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JokeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        Boolean loggedin = (Boolean)session.getAttribute("loggedin");
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (loggedin) {
            System.out.println("logged in");
            try {
                System.out.println("entered try");
                Connection connection = new DBConnection().getConnection();
                String sqlStatement = "SELECT username, jokeids FROM joketracker WHERE username = ?";
                PreparedStatement prepStatement = connection.prepareStatement(sqlStatement);
                prepStatement.setString(1, username);
                ResultSet resultSet = prepStatement.executeQuery();
                System.out.println("SELECT executed: " + resultSet.toString());
                if (resultSet.next()) {
                    System.out.println("entered inner if");
                    // while(resultSet.next()) {
                        // System.out.println("entered while");
                    Array arrFromTable = resultSet.getArray("jokeids");
                    Integer[] arr = (Integer[])arrFromTable.getArray();
                    ArrayList<Integer> arrToCheck = new ArrayList<Integer>();
                    Collections.addAll(arrToCheck, arr);
                    if (arrToCheck.contains(id)) {
                        System.out.println("id already present");
                        out.print("true");
                    } else {
                        System.out.println("id not present");
                        arrToCheck.add(id);
                        Array arrayToInsert = connection.createArrayOf("int4", arrToCheck.toArray());
                        String updateSQL = "UPDATE joketracker SET jokeids = ? WHERE username = ?";
                        PreparedStatement updateEntry = connection.prepareStatement(updateSQL);
                        updateEntry.setArray(1, arrayToInsert);
                        updateEntry.setString(2, username);
                        updateEntry.executeUpdate();
                        System.out.println("UPDATE executed!");
                        out.print("false");
                    }
                    // }
                    
                } else {
                    System.out.println("entered inner else");
                    Integer[] arr = new Integer[]{id};
                    Array arrayToInsert = connection.createArrayOf("int4", arr);
                    String createEntrySQL = "INSERT INTO joketracker (username, jokeids) VALUES (?, ?)";
                    PreparedStatement createEntry = connection.prepareStatement(createEntrySQL);
                    createEntry.setString(1, username);
                    createEntry.setArray(2, arrayToInsert);
                    createEntry.executeUpdate();
                    System.out.println("INSERT executed!");
                    out.print("false");
                }
                connection.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        } else {
            System.out.println("Not logged in...");
            out.print("false");
        }
        System.out.println("Joke servlet executed!");
        
    }
}