package com.java.passwordmanager.project;

import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);

    public static void menu() {
        boolean quitFlag = false;

        System.out.println("PASSWORD_PR0 by SS ");
        while (!quitFlag) {
            System.out.println("MENU\n" +
                    "1. Add/Create New Password Record\n" +
                    "2. Update Existing Password Record\n" +
                    "3. View Password Record for a Site/App\n" +
                    "Q. to Quit"
            );
            String choice = "";
            System.out.println("Enter Choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    insertRecord(); break;
                case "2":
                    System.out.println("case 2"); break;
                case "3":
                    System.out.println("case 3"); break;
                case "Q": {
                    System.out.println("Quit");
                    quitFlag = true; break;
                }
                default:
                    System.out.println("Please Enter A valid Input!!!");
            }
        }

    }

    public static void insertRecord() {
        String username = "", url = "", password = "";
        PasswordRecord newRecord = null;

        boolean validFlag = false;
        while (url.equals("")) {
            System.out.print("Enter Desired URL/App in format: ");
            scan.nextLine();
            url = scan.nextLine();
            if (url.equals("")) {
                System.out.println("This field Cannot Be Empty");
            }
        }

        while (username.equals("")) {
            System.out.print("Enter Username/UserID: ");
            username = scan.nextLine();
            if (username.equals("")) {
                System.out.println("Username/UserID Cannot Be Empty");
            }
        }

        while (password.equals("")) {
            System.out.print("Enter Password: ");
            password = scan.nextLine();
            if (password.equals("")) {
                System.out.println("Password Cannot Be Empty");
            }
        }

        try{
            newRecord = new PasswordRecord(username, url, password);
            newRecord.insertQuery();
        }
        catch (Exception e) {
            System.out.println("Error inserting values :(");
        }

    }
}





















