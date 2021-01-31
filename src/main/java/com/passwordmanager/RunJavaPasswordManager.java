package com.passwordmanager;


public class RunJavaPasswordManager {
    public static void main(String[] args) {

        DBConnect.initializeDatabase();
        DBConnect.dbOpenConnection();
        verifyMaster.verifyMasterPassword();
        Menu.menu();
        DBConnect.dbCloseConnection();
    }
}
