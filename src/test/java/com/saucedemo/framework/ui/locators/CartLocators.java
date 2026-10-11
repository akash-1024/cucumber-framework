package com.saucedemo.framework.ui.locators;

import org.openqa.selenium.By;

public final class CartLocators {
    public static final By TITLE = By.cssSelector(".title");
    public static final By CHECKOUT_BUTTON = By.id("checkout");

    private CartLocators() {
    }

    public static By itemName(String productName) {
        return By.xpath("//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']");
    }
}
