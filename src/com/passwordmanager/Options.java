package com.passwordmanager;

public class Options extends Menu{
    public static void insertRecord() {
        String username = "", url = "", password = "";
        CreatePasswordRecord newRecord = null;

        boolean validFlag = false;
        while (url.equals("")) {
            System.out.print("Enter Desired URL/App: ");
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
            newRecord = new CreatePasswordRecord(username, url, password);
            newRecord.insertQuery();
        }
        catch (Exception e) {
            System.out.println("Error inserting values :(");
        }

    }

    public static void updateRecord() {
        String username = "", url = "", password = "";
        while (url.equals("")) {
            System.out.print("Enter URL/App to update record: ");
            scan.nextLine();
            url = scan.nextLine();
            if (url.equals("")) {
                System.out.println("This field Cannot Be Empty");
            }
        }
    }
}
