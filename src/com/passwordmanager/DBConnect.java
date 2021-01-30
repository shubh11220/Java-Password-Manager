package com.passwordmanager;

import java.sql.*;


public class DBConnect {
    static Connection connection = null;


    static String dbName = "Java Password Manager";
    public static boolean dbExists = false;

    static final String USER = "username";
    static final String PASS = "password";

    public static void initializeDatabase() {

    }




    public static void dbOpenConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName , "postgres", "toor");
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
