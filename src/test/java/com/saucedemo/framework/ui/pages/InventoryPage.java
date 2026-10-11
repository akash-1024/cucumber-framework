package com.saucedemo.framework.ui.pages;

import com.saucedemo.framework.ui.locators.InventoryLocators;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String title() {
        return textOf(InventoryLocators.TITLE);
    }

    public void addProductToCart(String productName) {
        click(InventoryLocators.addToCartButton(productName));
    }

    public void openCart() {
        click(InventoryLocators.CART_LINK);
    }

    public String cartItemCount() {
        return textOf(InventoryLocators.CART_BADGE);
    }

    public void sortPriceLowToHigh() {
        selectVisibleText(InventoryLocators.SORT_DROPDOWN, "Price (low to high)");
    }

    public String firstProductPrice() {
        return textOf(InventoryLocators.FIRST_PRODUCT_PRICE);
    }
}
