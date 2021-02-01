package com.passwordmanager;


public class Runner {
    public static void main(String[] args) {

        DBConnect.initializeDatabase();
        DBConnect.dbOpenConnection();
        verifyMaster.verifyMasterPassword();
        Menu.menu();
        DBConnect.dbCloseConnection();
    }
}
