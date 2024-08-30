package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By SIGN_IN_PAGE_LINK = new By.ByClassName("login");



    public void navigateToSignInPage() {

        navigateTo(SIGN_IN_PAGE_LINK);
    }

}
