package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Page{

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    // Create new account field locators
    private static final By H1_CREATE_ACCOUNT = new By.ByXPath("//h1[text()='Create an account']");
    private static final By EMAIL_INPUT = new By.ById("email_create");
    private static final By CREATE_ACCOUNT_BUTTON = new By.ById("SubmitCreate");
    private static final By TITLE_CHECKBOX = new By.ById("uniform-id_gender1");
    private static final By FIRST_NAME_INPUT = new By.ById("customer_firstname");
    private static final By LAST_NAME_INPUT = new By.ById("customer_lastname");
    private static final By USER_EMAIL_INPUT = new By.ById("email");
    private static final By PASSWORD_INPUT = new By.ById("passwd");
    private static final By DAY_SELECT = new By.ById("days");
    private static final By MONTH_SELECT = new By.ById("months");
    private static final By YEAR_SELECT = new By.ById("years");
    private static final By SUBMIT_BUTTON = new By.ById("submitAccount");
    private static final By SUCCESS_MESSAGE = new By.ByXPath("//p[@class='alert alert-success']");

    // Login with existing user section field locators
    private static final By EMAIL_ADDRESS = new By.ById("email");
    private static final By PASSWORD = new By.ById("passwd");
    private static final By SIGNIN_BUTTON = new By.ById("SubmitLogin");
    private static final By MY_SECTION_HEADER = new By.ByXPath("//h1[text()='My account']");


}
