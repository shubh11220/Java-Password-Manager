package com.passwordmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DBConnect {
    static Connection connection = null;
    public static void dbOpenConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbTest", "postgres", "toor");
            if (connection != null) {
                System.out.println("Connection to Database Opened Successfully!");
            }
        }
        catch (Exception e) {
            System.out.println("Connection failed :(");
        }
    }
    public static void dbCloseConnection() {
        try {
            connection.close();
            System.out.println("Connection to Database CLOSED successfully!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
