package sample.ecommerce;

import com.aventstack.extentreports.Status;
import org.example.base.BaseHelper;
import org.example.pages.*;
import org.example.utilities.InvalidDataForLogIn;
import org.example.utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseHelper {

    @Test(priority = 1, groups = "{smoke}")
    public void create_new_user_and_verify_success_message() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.navigateToSignInPage();
        node.log(Status.INFO, "Navigated to sign in page");

        signInPage.enterEmailAddress(Utils.getRandomEmail(5));
        signInPage.clickCreateButton();
        boolean status = signInPage.verifyCreateAccountHeaderIsPresent();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Create account header is present");
        signInPage.fillUserInformation(Utils.getFirstName(5), Utils.getLastName(5), Utils.getRandomPassword(7));
        signInPage.selectDateOfBirth(Utils.getRandomNumber(), Utils.getRandomMonth(), "2000");
        signInPage.clickRegisterButton();

        boolean successMessageStatus = signInPage.verifySuccessMessage();
        Assert.assertTrue(successMessageStatus);
        node.log(Status.INFO, "Success message displayed after creating new user.");
    }

    @Test(priority = 2)
    public void verify_user_able_to_sign_in_with_valid_credentials() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.navigateToSignInPage();
        node.log(Status.INFO, "Navigated to sign in page");

        signInPage.loginWithExistingUserInformation();
        boolean status = signInPage.verifyMyAccountHeaderIsPresent();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Create account header is present");
    }

    @Test(priority = 3, dataProvider = "invalidLoginData", dataProviderClass = InvalidDataForLogIn.class, enabled = false)
    public void verify_error_message_displays_when_user_login_with_invalid_credentials(String email, String password) {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.navigateToSignInPage();
        node.log(Status.INFO, "Navigated to sign in page");

        signInPage.loginWithIncorrectUserInformation(email, password);
        boolean status = signInPage.verifyAuthenticationFailedErrorMessageIsDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Authentication failed error message displayed");
    }

    @Test(priority = 4)
    public void verify_shopping_cart_section_is_empty_for_new_user() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.createNewUser();
        node.log(Status.INFO, "Created new user successfully");

        MyContactPage myContactPage = new MyContactPage(driver);
        myContactPage.clickShopCart();
        boolean status = myContactPage.verifyInfoMessageDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Info message displayed on my contact page");

        signInPage.signOut();
        node.log(Status.INFO, "Signed out successfully");
    }

    @Test(priority = 5)
    public void verify_success_message_displays_when_user_retrieve_password_using_forgot_password() {

        SignInPage signInPage = new SignInPage(driver);
        String email = signInPage.createNewUser();
        node.log(Status.INFO, "Created new user successfully to retrieve password");
        signInPage.signOut();
        node.log(Status.INFO, "Signed out successfully");

        signInPage.navigateToSignInPage();
        signInPage.retrievePassword(email);
        boolean status = signInPage.verifyRetrievePasswordEmailConfirmationIsDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Retrieve password email confirmation message displayed");
    }

    @Test(priority = 6)
    public void verify_my_order_section_is_empty_for_new_user() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.createNewUser();
        node.log(Status.INFO, "Created new user successfully");

        MyContactPage myContactPage = new MyContactPage(driver);
        myContactPage.clickMyAccountOrderHistory();
        boolean status = myContactPage.verifyInfoMessageDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Info message displayed on my contact page");
        signInPage.signOut();
        node.log(Status.INFO, "Signed out successfully after verification");
    }

    @Test(priority = 7)
    public void verify_my_credit_slip_section_is_empty_for_new_user() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.createNewUser();
        node.log(Status.INFO, "Created new user successfully");

        MyContactPage myContactPage = new MyContactPage(driver);
        myContactPage.clickMyAccountCreditSlips();
        boolean status = myContactPage.verifyInfoMessageDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Info message displayed on my contact page");
        signInPage.signOut();
        node.log(Status.INFO, "Signed out successfully after verification");
    }

    @Test(priority = 8)
    public void search_product_and_verify_search_result() {

        String productName = "shirts";
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(productName);
        node.log(Status.INFO, "Product searched successfully");

        homePage.verifySearchResultsName(productName);
        homePage.verifySearchResultsContainsProductName(productName);
        node.log(Status.INFO, "Searched product contain search item detail");
    }

    @Test(priority = 9)
    public void send_query_to_customer_service_and_verify_success_message() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.createNewUser();
        node.log(Status.INFO, "New user created successfully");

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.navigateToContactUsPage();
        node.log(Status.INFO, "Navigated to contact us page successfully");

        boolean headerStatus = contactUsPage.verifyContactUsHeaderIsDisplayed();
        Assert.assertTrue(headerStatus);
        contactUsPage.fillInformationToContact("Customer service", Utils.getMessage(7));
        boolean successMessageStatus = contactUsPage.verifySuccessMessageDisplayed();
        Assert.assertTrue(successMessageStatus);
        node.log(Status.INFO, "Query send to customer service and Success message displayed");
    }

    @Test(priority = 10)
    public void verify_success_message_displays_when_user_subscribe_the_newsletter() {

        SignInPage signInPage = new SignInPage(driver);
        String email = signInPage.createNewUser();
        node.log(Status.INFO, "New user created successfully");

        HomePage homePage = new HomePage(driver);
        homePage.scrollToFooterSection();
        homePage.subscribeTheNewsLetter(email);
        boolean status = homePage.verifyNewsLetterSuccessMessageIsDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Query send to customer service and Success message displayed");
    }

    @Test(priority = 11)
    public void verify_company_address_information_available_on_footer() {

        HomePage homePage = new HomePage(driver);
        homePage.scrollToFooterSection();
        node.log(Status.INFO, "Scrolled to footer section successfully");

        boolean status = homePage.verifyAddressIsPresent();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Company address available on footer section");
    }

    @Test(priority = 12)
    public void verify_info_message_displays_when_customer_not_having_address() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.createNewUser();
        node.log(Status.INFO, "New user created successfully");

        MyContactPage myContactPage = new MyContactPage(driver);
        myContactPage.clickMyAccountMyAddress();
        boolean status = myContactPage.verifyInfoMessageDisplayed();
        Assert.assertTrue(status);
        node.log(Status.INFO, "Info message displayed successfully on my contact page");

        signInPage.signOut();
        node.log(Status.INFO, "Signed out successfully");
    }

}
