package org.example.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browserName) {

        browserName = (browserName != null) ? browserName : "";

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            maximizeBrowser();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            maximizeBrowser();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            maximizeBrowser();

        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            maximizeBrowser();

        }

        return driver;
    }

    public static void maximizeBrowser() {
        driver.manage().window().maximize();
    }

}
