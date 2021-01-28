package com.passwordmanager;

import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class verifyMaster {
    static String defaultMaster = "DEFAULT_KEY";
    private static String masterHash = "";
    private static String master = defaultMaster;
    String keystorePass = "DEFAULT_KEY";

//    public static boolean verifyMaster() {
//        System.out.println("Input Master Password: ");
//        var scan = new Scanner(System.in);
//        master = scan.nextLine();
//        System.out.println();
//
//
//    }
//
//    public static void storeToKeyStore(SecretKey keyToSTore, String keystorePass, ) {
//
//    }



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
