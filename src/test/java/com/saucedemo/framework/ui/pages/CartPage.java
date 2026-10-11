package com.saucedemo.framework.ui.pages;

import com.saucedemo.framework.ui.locators.CartLocators;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean containsProduct(String productName) {
        return isVisible(CartLocators.itemName(productName));
    }

    public void checkout() {
        click(CartLocators.CHECKOUT_BUTTON);
    }
}
