package com.passwordmanager;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Options extends Menu{
    private static String getUsernameFromUser() {
        String username = "";
        while (username.equals("")) {
            System.out.print("Enter Username/UserID: ");
            username = scan.nextLine();
            if (username.equals("")) {
                System.out.println("Username/UserID Cannot Be Empty");
            }
        }
        return username;
    }

    private static String getURLfromUser() {
        String url = "";
        while (url.equals("")) {
            System.out.print("Enter Desired URL/App: ");
            scan.nextLine();
            url = scan.nextLine();
            if (url.equals("")) {
                System.out.println("This field Cannot Be Empty");
            }
        }
        return url;
    }

    private static String getPasswordFromUser() {
        String password = "";
        while (password.equals("")) {
            System.out.print("Enter Password: ");
            password = scan.nextLine();
            if (password.equals("")) {
                System.out.println("Password Cannot Be Empty");
            }
        }
        return password;
    }


    public static void insertRecord() {
        String username = "", url = "", password = "";
        CreatePasswordRecord newRecord = null;

        url = getURLfromUser();
        username = getUsernameFromUser();
        password = getPasswordFromUser();

        try{
            newRecord = new CreatePasswordRecord(username, url, password);
            newRecord.insertQuery();
        }
        catch (Exception e) {
            System.out.println("Error inserting values :(");
        }

    }


    public static void updateRecord() {
        String username, url = "", password;
        while (url.equals("")) {
            System.out.print("Enter URL/App to update record: ");
            scan.nextLine();
            url = scan.nextLine();
            if (url.equals("")) {
                System.out.println("This field Cannot Be Empty");
            }
        }
        String query = String.format("SELECT fname, address FROM test1 WHERE lname = '%s';", url);
        try {
            Statement update = connection.createStatement();
            ResultSet rs = update.executeQuery(query);
            rs.next();
            username = rs.getString(1);
            password = rs.getString(2);
            System.out.println("The following are the current details of this record");
            System.out.println("URL/App: " + url);
            System.out.println("Username/UserID: " + username);
            System.out.println("Password: " + password + "\n");

            String choice;
            boolean quitFlag = false;
            while(!quitFlag) {
                System.out.println("Press U to edit Username/UserID or P to edit Password, X to go back");
                choice = scan.next();
                switch (choice) {
                    case "U":
                        username = getUsernameFromUser();
                        query = String.format("UPDATE test1 SET fname = '%s' WHERE lname = '%s';", username, url);
                        update.execute(query);
                        System.out.println("Username/UserID updated successfully!\n"); quitFlag = true; break;

                    case "P":
                        password = getPasswordFromUser();
                        query = String.format("UPDATE test1 SET address = '%s' WHERE lname = '%s';", password, url);
                        update.execute(query);
                        System.out.println("Password updated successfully!\n"); quitFlag = true; break;

                    case "X":
                        System.out.println();
                        quitFlag = true; break;
                    default:
                        System.out.println("Enter a valid input!");
                }

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Record with this url does not exist, or an error occurred :( \n");
        }

    }

    public static void getRecord() {
        String username, url = "", password;
        while (url.equals("")) {
            System.out.print("Enter URL/App to update record: ");
            scan.nextLine();
            url = scan.nextLine();
            if (url.equals("")) {
                System.out.println("This field Cannot Be Empty");
            }
        }
        String query = String.format("SELECT fname, address FROM test1 WHERE lname = '%s';", url);
        try {
            Statement update = connection.createStatement();
            ResultSet rs = update.executeQuery(query);
            rs.next();
            username = rs.getString(1);
            password = rs.getString(2);
            System.out.println("The following are the current details of this record");
            System.out.println("URL/App: " + url);
            System.out.println("Username/UserID: " + username);
            System.out.println("Password: " + password);
            // copies password to device clipboard for usage
            StringSelection data = new StringSelection(password);
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(data, data);
            System.out.println("Password copied to your clipboard!");
            scan.nextLine();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Record with this url does not exist, or an error occurred :( \n");
        }

    }
}
