package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends Page{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private static final By CONTACT_US_LINK = new By.ById("contact-link");
    private static final By CONTACT_US_HEADER = new By.ByXPath("//h1[@class='page-heading bottom-indent']");
    private static final By SUBJECT_HEADING_SELECT = new By.ById("id_contact");
    private static final By EMAIL_ADDRESS_INPUT = new By.ById("email");
    private static final By MESSAGE_TEXT_BOX = new By.ById("message");
    private static final By SUBMIT_MESSAGE_BUTTON = new By.ById("submitMessage");
    private static final By SUCCESS_MESSAGE = new By.ByXPath("//p[@class='alert alert-success']");


    public void navigateToContactUsPage() {

        navigateTo(CONTACT_US_LINK);
        System.out.println("... Navigated to Contact us page ...");
    }

    public boolean verifyContactUsHeaderIsDisplayed() {

        return isElementDisplayed(CONTACT_US_HEADER);
    }

    public void fillInformationToContact(String subject, String message) {

        selectByVisibleText(SUBJECT_HEADING_SELECT, subject);
        click(EMAIL_ADDRESS_INPUT);
        type(MESSAGE_TEXT_BOX, message);
        click(SUBMIT_MESSAGE_BUTTON);
        System.out.println("... Information filled to contact ...");
    }

    public boolean verifySuccessMessageDisplayed() {

        return isElementDisplayed(SUCCESS_MESSAGE);
    }



}
