package org.example.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {

    private Utils() {

    }

    /* This method use to get random email.
    * @param - length
    * return the random email.
    * */
    public static String getRandomEmail(int length) {

        String randomValue = RandomStringUtils.randomAlphabetic(length);
        return randomValue+"@gmail.com";
    }

    /* This method use to get random password.
     * @param - length
     * return the random password.
     * */
    public static String getRandomPassword(int length) {

        return RandomStringUtils.randomAlphabetic(length);
    }

    /* This method use to get random value.
     * @param - length
     * return the random first name.
     * */
    public static String getFirstName(int length) {

        String name = RandomStringUtils.randomAlphabetic(length);
        return name+" first";
    }

    /* This method use to get random value.
     * @param - length
     * return the random last name.
     * */
    public static String getLastName(int length) {

        String name = RandomStringUtils.randomAlphabetic(length);
        return name+" last";
    }

    /* This method use to get random number.
     * @param - length
     * return the random number between 1 and 27.
     * */
    public static String getRandomNumber() {

        Random rand = new Random();
        int max=27, min=1;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

    /* This method use to get random month as number.
     * @param - length
     * return the random month.
     * */
    public static String getRandomMonth() {

        Random rand = new Random();
        int max=12, min=1;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

    /* This method use to replace special char.
     * @param - length
     * return the string after replacing the special char.
     * */
    public static String transformString(String valueToTransform) {
        return valueToTransform.replaceAll("\"", "");
    }

    /* This method use to get random message.
     * @param - length
     * return the random message.
     * */
    public static String getMessage(int length) {
        String randomMessage = RandomStringUtils.randomAlphabetic(length);
        return "This is test "+randomMessage;
    }

    /* This method use to get current date and time.
     * return the current date and time.
     * */
    public static String getCurrentDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateAndTime = localDateTime.format(formatter);
        return dateAndTime.replaceAll("[/:]", "-");
    }

    /* This method use to take screenshot of web page.
     * @param - filePath and driver (reference variable)
     * */
    public static void takeScreenshot(String filePath, WebDriver driver) {

        try {
            TakesScreenshot tc = (TakesScreenshot) driver;
            File srcImg = tc.getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);
            FileUtils.copyFile(srcImg, destFile);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
