package com.passwordmanager;


public class Runner {
    public static void main(String[] args) {

//        DBConnect.initializeDatabase();
        DBConnect.dbOpenConnection();
        verifyMaster.verifyMasterPassword(); // login system
        Menu newMenu = new Menu();
        newMenu.menu();
        DBConnect.dbCloseConnection();
    }
}
