package sample.ecommerce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.configuration.PropertyReader;
import org.example.pageobjects.SignInPage;
import org.example.utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @Test(priority = 1)
    public void create_new_user() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.navigateToSignInPage();
        signInPage.enterEmailAddress(Utils.getRandomEmail(5));
        signInPage.clickCreateButton();
        boolean status = signInPage.verifyCreateAccountHeaderIsPresent();
        Assert.assertTrue(status);
        signInPage.fillUserInformation(Utils.getFirstName(5), Utils.getLastName(5), Utils.getRandomPassword(7));
        signInPage.selectDateOfBirth(Utils.getRandomNumber(), Utils.getRandomMonth(), "2000");
        signInPage.clickRegisterButton();
        boolean successMessageStatus = signInPage.verifySuccessMessage();
        Assert.assertTrue(successMessageStatus);
    }

    @Test(priority = 2)
    public void verify_user_able_to_sign_in_with_valid_credentials() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.navigateToSignInPage();
        signInPage.loginWithExistingUserInformation();
        boolean status = signInPage.verifyMyAccountHeaderIsPresent();
        Assert.assertTrue(status);
    }

    @Test(priority = 3)
    public void verify_shopping_cart_section_is_empty_for_new_user() {

    }

    @Test(priority = 4)
    public void verify_my_order_section_is_empty_for_new_user() {

    }

    @Test(priority = 5)
    public void verify_my_credit_slip_section_is_empty_for_new_user() {

    }

    @Test(priority = 6)
    public void search_product_verify_search_result() {

    }

    @Test(priority = 7)
    public void send_query_to_customer_service_and_verify_success_message() {

    }

    @Test(priority = 8)
    public void verify_success_message_displays_when_user_subscribe_the_newsletter() {

    }

    @Test(priority = 9)
    public void verify_success_message_displays_when_user_retrieve_password_using_forgot_password() {

    }

    @Test(priority = 10)
    public void verify_company_address_information_available_on_footer() {

    }

    @Test(priority = 11)
    public void verify_info_message_displays_when_customer_not_having_address() {

    }


}
