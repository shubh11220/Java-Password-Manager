package com.passwordmanager;

import java.util.Scanner;

public class Menu extends DBConnect {
    static Scanner scan = new Scanner(System.in);

    public void menu() {
        Options options = new Options();

        boolean quitFlag = false;

        System.out.println(Other.asciiHeader);
        DBConnect.dbOpenConnection();
        while (!quitFlag) {
            System.out.println("__________________________________");
            System.out.println("MENU\n" +
                    "1. Add/Create New Password Record\n" +
                    "2. Update Existing Password Record\n" +
                    "3. View Password Record for a Site/App\n" +
                    "4. Reset Master Password\n" +
                    "Q. to Quit"
            );
            String choice = "";
            System.out.println("Enter Choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    options.insertRecord(); break;
                case "2":
                    options.updateRecord(); break;
                case "3":
                    options.getRecord();    break;
                case "4":
                    verifyMaster.resetMasterHash(); break;
                case "Q": {
                    DBConnect.dbCloseConnection();
                    System.out.println("Quitting...");
                    quitFlag = true; break;
                }
                default:
                    System.out.println("Please Enter A valid Input!!!");
            }
        }
    }
}





















