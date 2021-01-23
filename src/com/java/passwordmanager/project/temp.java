package com.java.passwordmanager.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;



public class temp {
    public static void dbConnect() {
        try {
            Connection connection = null;
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbTest", "postgres", "toor");
            if (connection != null) {
                System.out.println("Connection to Database Established!");
            }
            else System.out.println("Connection failed :(");
        }
        catch (Exception e) {

        }
    }
}
