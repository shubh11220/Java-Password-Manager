package com.passwordmanager;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class verifyMaster extends DBConnect{
    static String defaultMaster = "DEFAULT_KEY";
    private static String master = defaultMaster;
    String keystorePass = "DEFAULT_KEY";
    private static String masterHashDB = "";
    static Scanner scan = new Scanner(System.in);

    public static void  verifyMasterPassword() {
        setMasterHashDB();
        if (masterExists()) {
            verify();
        }
        else resetMasterHash();
    }


    private static void verify() {
        String masterInput = "";
        System.out.println("Enter Master Password (default is 'DEFAULT_KEY') : ");
        masterInput = scan.nextLine();
        String inputHash = bytesToHex(getSHA(masterInput));
        if (!inputHash.equals(getMasterHashDB())) {
            System.out.println("Incorrect Master Password :( [Exiting]...");
            dbCloseConnection();
            System.exit(-1);
        }
        System.out.println("Congrats you now have access!");
    }

    private static void setMasterHashDB() {
        String query = "select master from master";
        try {
            Statement update = connection.createStatement();
            ResultSet rs = update.executeQuery(query);
            rs.next();
            masterHashDB = rs.getString(1); }
        catch (Exception e) {
            System.out.println("Error:(");
        }
    }
    public static String getMasterHashDB() {
        return masterHashDB;
    }

    public static void resetMasterHash() {
        //if master is empty
        System.out.println("Enter Master Password you want to set: ");
        String inputMaster = scan.nextLine();
        if (inputMaster.equals("")) inputMaster = defaultMaster;
        String query = String.format("INSERT INTO MASTER VALUES ('%s');", bytesToHex(getSHA(inputMaster)));
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables) {

        }
    }

    public static boolean masterExists() {
        return !masterHashDB.equals("") || masterHashDB != null;
    }


    public static byte[] getSHA(String input) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error Hashing :(");
        }
        assert md != null;
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
