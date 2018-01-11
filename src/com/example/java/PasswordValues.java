package com.example.java;

import java.security.SecureRandom;

public class PasswordValues {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase();
    private static final String NUMBERS = "0123456789";


    public static String getLOWER() {
        return LOWER;
    }

    public static String getUPPER() {
        return UPPER;
    }

    public static String getNUMBERS() {
        return NUMBERS;
    }

}
