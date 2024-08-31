package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page {

    private final WebDriver driver;
    private final long TIMEOUT = 30L;

    public Page(WebDriver driver) {
       this.driver = driver;
    }

    protected void navigateTo(By by) {

        try {
            WebElement element = waitForElementClickable(by);
            element.click();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    protected String getText(By by) {

        String text = null;

        try {
            WebElement element = waitForElementVisible(by);
            text =  element.getText();
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return text;
    }

    protected void type(By by, String input) {

        try {
            WebElement element = waitForElementVisible(by);
            element.clear();
            element.sendKeys(input);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void click(By by) {

        try {
            WebElement element = waitForElementClickable(by);
            element.click();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void selectByValue(By by, String value) {

        try {

            WebElement element = waitForElementPresent(by);
            Select select = new Select(element);
            select.selectByValue(value);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void selectByVisibleText(By by, String text) {

        try {
            WebElement element = waitForElementPresent(by);
            Select select = new Select(element);
            select.selectByVisibleText(text);
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void checkRadioButton(By by) {

        try {
            WebElement element = waitForElementClickable(by);
            if (!element.isSelected()) {
                element.click();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void scrollToElementView(By by) {
        WebElement element = waitForElementPresent(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isElementDisplayed(By by) {
        try {
            WebElement element = waitForElementVisible(by);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected List<WebElement> getListElements(By by) {

        List<WebElement> elements = null;

        try {
            waitForElementPresent(by);
            elements =  driver.findElements(by);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return elements;
    }

    protected WebElement waitForElementVisible(By by) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  element;
    }

    protected WebElement waitForElementClickable(By by) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  element;
    }

    protected WebElement waitForElementPresent(By by) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  element;
    }


}