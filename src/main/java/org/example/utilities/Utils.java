package org.example.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Utils {

    private Utils() {

    }

    public static String getRandomEmail(int length) {

        String randomValue = RandomStringUtils.randomAlphabetic(length);
        return randomValue+"@gmail.com";
    }

    public static String getRandomPassword(int length) {

        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getFirstName(int length) {

        String name = RandomStringUtils.randomAlphabetic(length);
        return name+" first";
    }

    public static String getLastName(int length) {

        String name = RandomStringUtils.randomAlphabetic(length);
        return name+" last";
    }

    public static String getRandomNumber() {

        Random rand = new Random();
        int max=27, min=1;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

    public static String getRandomMonth() {

        Random rand = new Random();
        int max=12, min=1;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }
}
