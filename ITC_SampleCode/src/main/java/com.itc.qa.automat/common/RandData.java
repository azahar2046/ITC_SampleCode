package com.itc.qa.automat.common;

import java.security.SecureRandom;
import java.util.Random;

public class RandData {

    public static Integer getRandomInt(Integer range, Integer minimum) {

        Random random = new SecureRandom();

        return random.nextInt(range - minimum) + minimum;
    }

    public static String getRandomIntAsString(Integer range, Integer minimum) {

        return String.valueOf(getRandomInt(range, minimum));
    }

    public static String getRandomMobileNumber() {

        return  getRandomIntAsString(99999, 10000)+getRandomIntAsString(99999, 10000);
    }

    public static String getRandomMail() {

        return "qa_automat_" + getRandomIntAsString(99999999, 10000000)+"@gmail.com";
    }

    private static String getRandomString(String chars, Integer length) {

        if(length <= 0) {

            throw new RuntimeException("Length has to be greater than 0");
        }

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length; i++) {

            builder.append(chars.charAt(getRandomInt(chars.length(), 0)));
        }

        return builder.toString();
    }

    public static String getRandomStringWithoutAdditionalCharacters(Integer length) {

        return getRandomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", length);
    }

}
