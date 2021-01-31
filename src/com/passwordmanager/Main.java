package com.passwordmanager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        DBConnect.initializeDatabase();
        DBConnect.dbOpenConnection();
        verifyMaster.verifyMasterPassword();
        Menu.menu();
        DBConnect.dbCloseConnection();
    }
}
