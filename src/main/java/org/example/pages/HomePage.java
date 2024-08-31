package org.example.pages;

import org.example.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // Search field locator
    private static final By SEARCH_INPUT = new By.ById("search_query_top");
    private static final By SEARCH_BUTTON = new By.ByName("submit_search");
    private static final By SEARCHED_ITEM_NAME = new By.ByClassName("lighter");
    private static final By SEARCHED_RESULTS_PRODUCT_NAME = new By.ByXPath("//h5[@itemprop='name']//a");

    // Store address section
    private static final By STORE_ADDRESS = new By.ByClassName("icon-map-marker");

    // Newsletter section
    private static final By INPUT_NEWS_LETTTER = new By.ById("newsletter-input");
    private static final By INPUT_NEWS_LETTTER_BUTTON = new By.ByName("submitNewsletter");
    private static final By NEWS_LETTER_SUCCESS_MESSAGE = new By.ByXPath("//p[contains(@class, 'alert-success')]");


    public void scrollToFooterSection() {
        scrollToElementView(STORE_ADDRESS);
        System.out.println("... Page scrolled to footer successfully ...");
    }
    public boolean verifyAddressIsPresent() {
        return isElementDisplayed(STORE_ADDRESS);
    }
    public void subscribeTheNewsLetter(String email) {

        click(INPUT_NEWS_LETTTER);
        type(INPUT_NEWS_LETTTER, email);
        click(INPUT_NEWS_LETTTER_BUTTON);
        System.out.println("... News letter information entered and clicked ...");
    }
    public boolean verifyNewsLetterSuccessMessageIsDisplayed() {
        return isElementDisplayed(NEWS_LETTER_SUCCESS_MESSAGE);
    }
    public void searchProduct(String productName) {

        type(SEARCH_INPUT, productName);
        click(SEARCH_BUTTON);
        System.out.println("... Product searched successfully ...");
    }
    public void verifySearchResultsName(String productName) {

        String searchedResult = getText(SEARCHED_ITEM_NAME);
        String searchedProduct = Utils.transformString(searchedResult);
        Assert.assertEquals(searchedProduct.toLowerCase(), productName);
        System.out.println("... Search result verified successfully ...");
    }
    public void verifySearchResultsContainsProductName(String productName) {

        List<WebElement> elements = getListElements(SEARCHED_RESULTS_PRODUCT_NAME);
        for (WebElement element:elements) {

            String searchedResult = element.getText();
            Assert.assertTrue(searchedResult.contains(productName));
            System.out.println("... Search result contains "+productName+" successfully ...");
        }
    }
}
