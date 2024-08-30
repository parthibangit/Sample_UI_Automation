package sample.ecommerce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.pageobjects.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @Test(priority = 1)
    public void create_new_user() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateToSignInPage();
    }

    @Test(priority = 2)
    public void sign_in_with_valid_credentials() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateToSignInPage();
    }

    @Test
    public void search_product_verify_search_result() {

    }

    @Test
    public void send_query_to_customer_service_and_verify_success_message() {

    }

    @Test
    public void verify_shopping_cart_is_empty_for_new_user() {

    }

    @Test
    public void verify_success_message_displays_when_user_subscribe_the_newsletter() {

    }

    @Test
    public void verify_success_message_displays_when_user_retrieve_password_using_forgot_password() {

    }


}
