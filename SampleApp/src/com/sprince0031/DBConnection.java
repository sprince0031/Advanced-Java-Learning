package com.sprince0031;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnection {
    
    private DataSource dataSource;
    public void Database(String jndiName) {
        
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/" + jndiName);
        } catch (NamingException e) {
            throw new IllegalStateException(jndiName + " is missing!");
        }
        
    }

    public Connection getConnection() throws SQLException {
        Database("jdbc/postgres");
        return dataSource.getConnection();
    }

}