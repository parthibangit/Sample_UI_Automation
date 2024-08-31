package org.example.pages;

import org.example.configuration.PropertyReader;
import org.example.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage extends Page {

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    // Create new account section locators
    private static final By SIGN_IN_PAGE_LINK = new By.ByClassName("login");
    private static final By EMAIL_INPUT = new By.ById("email_create");
    private static final By CREATE_ACCOUNT_BUTTON = new By.ById("SubmitCreate");
    private static final By H1_CREATE_ACCOUNT = new By.ByXPath("//h1[text()='Create an account']");
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

    // Login with existing user section locators
    private static final By EMAIL_ADDRESS = new By.ById("email");
    private static final By PASSWORD = new By.ById("passwd");
    private static final By SIGNIN_BUTTON = new By.ById("SubmitLogin");
    private static final By MY_SECTION_HEADER = new By.ByXPath("//h1[text()='My account']");

    // Forgot password section locators
    private static final By FORGOT_PASSWORD_LINK_TEXT = new By.ByLinkText("Forgot your password?");
    private static final By FORGOT_PASSWORD_HEADER= new By.ByClassName("page-subheading");
    private static final By FORGOT_PASSWORD_EMAIL_ADDRESS_INPUT = new By.ById("email");
    private static final By RETRIEVE_PASSWORD_BUTTON = new By.ByXPath("(//button[@type='submit'])[2]");
    private static final By RETRIEVE_PASSWORD_SUCCESS_MESSAGE = new By.ByXPath("//p[@class='alert alert-success']");

    // Sign out locator
    private static final By SIGN_OUT_LINK = new By.ByClassName("logout");


    public void navigateToSignInPage() {

        navigateTo(SIGN_IN_PAGE_LINK);
        System.out.println("... Navigated to Sign in page ...");
    }

    public void enterEmailAddress(String email) {
        type(EMAIL_INPUT, email);
        System.out.println("... Email address inputted ...");
    }

    public void clickCreateButton() {
        click(CREATE_ACCOUNT_BUTTON);
        System.out.println("... Clicked create button ...");
    }

    public boolean verifyCreateAccountHeaderIsPresent() {
        return isElementDisplayed(H1_CREATE_ACCOUNT);
    }

    public void fillUserInformation(String firstName, String lastName, String password) {

        checkRadioButton(TITLE_CHECKBOX);
        type(FIRST_NAME_INPUT, firstName);
        type(LAST_NAME_INPUT, lastName);
        click(USER_EMAIL_INPUT);
        type(PASSWORD_INPUT, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectByValue(DAY_SELECT, day);
        selectByValue(MONTH_SELECT, month);
        selectByValue(YEAR_SELECT, year);
        System.out.println("... User information entered successfully ...");
    }

    public void clickRegisterButton() {
        click(SUBMIT_BUTTON);
        System.out.println("... Register button clicked ...");
    }

    public boolean verifySuccessMessage() {

        return isElementDisplayed(SUCCESS_MESSAGE);
    }

    public void loginWithExistingUserInformation() {
        type(EMAIL_ADDRESS, PropertyReader.getInstance().getValue("email"));
        type(PASSWORD, PropertyReader.getInstance().getValue("pwd"));
        click(SIGNIN_BUTTON);
        System.out.println("... Logged in successfully ...");
    }

    public boolean verifyMyAccountHeaderIsPresent() {
        return isElementDisplayed(MY_SECTION_HEADER);
    }

    public String createNewUser() {

        navigateToSignInPage();
        String email = Utils.getRandomEmail(5);
        enterEmailAddress(email);
        clickCreateButton();
        fillUserInformation(Utils.getFirstName(5), Utils.getLastName(5), Utils.getRandomPassword(7));
        selectDateOfBirth(Utils.getRandomNumber(), Utils.getRandomMonth(), "1998");
        clickRegisterButton();
        verifySuccessMessage();
        return email;
    }

    public void signOut() {

        click(SIGN_OUT_LINK);
        System.out.println("... Sign out button clicked successfully ...");

    }

    public void retrievePassword(String email) {
        click(FORGOT_PASSWORD_LINK_TEXT);
        boolean status = isElementDisplayed(FORGOT_PASSWORD_HEADER);
        Assert.assertTrue(status);
        type(FORGOT_PASSWORD_EMAIL_ADDRESS_INPUT, email);
        click(RETRIEVE_PASSWORD_BUTTON);
        System.out.println("... Email entered and clicked successfully for retrieve password ...");
    }

    public boolean verifyRetrievePasswordEmailConfirmationIsDisplayed() {
        return isElementDisplayed(RETRIEVE_PASSWORD_SUCCESS_MESSAGE);
    }

}