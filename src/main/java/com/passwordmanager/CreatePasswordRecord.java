package com.passwordmanager;

import java.sql.SQLException;
import java.sql.Statement;

public class CreatePasswordRecord extends Menu {
    private String username = "", url = "", password = "";
    private int record_id = -1;
    String insertionQuery;

    CreatePasswordRecord(String username, String url, String password) {
        setPassword(password);
        setUrl(url);
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getInsertionQuery() {
        return insertionQuery;
    }

    public void setInsertionQuery() {
        insertionQuery = "INSERT INTO PasswordRecords (username, url, passwd)" +
                "VALUES (" +
                "'" + getUsername() + "', "
                + "'" + getUrl() + "', "
                + "'" + getPassword() +"'" +
                ");";
//        insertionQuery = "INSERT INTO PasswordRecords (username, url, passwd) VALUES ('usern', 'url', 'passw');";
    }

    public void insertQuery() {
        this.setInsertionQuery();
        try {
//            Connection connection = null;
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbTest", "postgres", "toor");
            Statement insert = connection.createStatement();
            insert.execute(insertionQuery);
            System.out.println("Values inserted successfully!\n");
//            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error inserting values...");
        }
    }

}
