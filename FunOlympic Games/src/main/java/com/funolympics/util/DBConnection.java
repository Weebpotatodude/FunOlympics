package com.funolympics.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/funolympics_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure you have the MySQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver not found");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}