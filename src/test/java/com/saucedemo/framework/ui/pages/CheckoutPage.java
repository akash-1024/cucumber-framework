package com.saucedemo.framework.ui.pages;

import com.saucedemo.framework.ui.locators.CheckoutLocators;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerDetails(String firstName, String lastName, String postalCode) {
        enterText(CheckoutLocators.FIRST_NAME, firstName);
        enterText(CheckoutLocators.LAST_NAME, lastName);
        enterText(CheckoutLocators.POSTAL_CODE, postalCode);
        click(CheckoutLocators.CONTINUE_BUTTON);
        waitFor(CheckoutLocators.FINISH_BUTTON);
    }

    public void finishOrder() {
        click(CheckoutLocators.FINISH_BUTTON);
    }

    public String confirmationMessage() {
        return textOf(CheckoutLocators.COMPLETE_HEADER);
    }
}
