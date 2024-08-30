package org.example.utilities;

import org.apache.commons.lang3.RandomStringUtils;

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

}
