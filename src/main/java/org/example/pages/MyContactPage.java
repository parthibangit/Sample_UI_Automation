package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyContactPage extends Page{

    private static final Logger logger = LoggerFactory.getLogger(MyContactPage.class);


    public MyContactPage(WebDriver driver) {
        super(driver);
    }

    private static final By ORDER_HISTORY_LINK = new By.ByXPath("//span[text()='Order history and details']");
    private static final By CREDIT_SLIPS_LINK = new By.ByXPath("//span[text()='My credit slips']");
    private static final By MY_ADDRESS_LINK = new By.ByXPath("//span[text()='My addresses']");
    private static final By SHOP_CART_LINK = new By.ByXPath("//a[@title='View my shopping cart']");
    private static final By INFO_MESSAGE = new By.ByXPath("//p[@class='alert alert-warning']");


    public void clickMyAccountOrderHistory() {

        click(ORDER_HISTORY_LINK);
        logger.info("... Order history section clicked ...");
    }

    public void clickMyAccountCreditSlips() {

        click(CREDIT_SLIPS_LINK);
        logger.info("... Credit slip section clicked ...");
    }

    public void clickMyAccountMyAddress() {

        click(MY_ADDRESS_LINK);
        logger.info("... My address section clicked ...");
    }

    public void clickShopCart() {

        click(SHOP_CART_LINK);
        logger.info("... Shop cart clicked ...");
    }

    public boolean verifyInfoMessageDisplayed() {
        return isElementDisplayed(INFO_MESSAGE);
    }


}
