package com.saucedemo.framework.business;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.saucedemo.framework.base.BaseTest;
import com.saucedemo.framework.ui.pages.CartPage;
import com.saucedemo.framework.ui.pages.CheckoutPage;
import com.saucedemo.framework.ui.pages.InventoryPage;
import com.saucedemo.framework.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class SauceDemoBusinessSteps {
    private static final String PASSWORD = "secret_sauce";

    public void openLoginPage() {
        new LoginPage(driver()).open();
    }

    public void login(String username, String password) {
        new LoginPage(driver()).loginAs(username, password);
    }

    public void loginAsStandardUser(String username) {
        openLoginPage();
        login(username, PASSWORD);
    }

    public void assertProductsPage() {
        assertEquals(inventoryPage().title(), "Products");
    }

    public void assertLoginError(String expectedError) {
        assertTrue(loginPage().errorMessage().contains(expectedError),
                "The login error should contain: " + expectedError);
    }

    public void addProductToCart(String productName) {
        inventoryPage().addProductToCart(productName);
    }

    public void assertCartContains(String productName) {
        InventoryPage inventory = inventoryPage();
        assertEquals(inventory.cartItemCount(), "1");
        inventory.openCart();
        assertTrue(new CartPage(driver()).containsProduct(productName),
                "The cart should contain " + productName);
    }

    public void purchaseProduct(String productName, String firstName, String lastName, String postalCode) {
        addProductToCart(productName);
        inventoryPage().openCart();
        CartPage cart = new CartPage(driver());
        assertTrue(cart.containsProduct(productName), "The cart should contain " + productName);
        cart.checkout();
        CheckoutPage checkout = new CheckoutPage(driver());
        checkout.enterCustomerDetails(firstName, lastName, postalCode);
        checkout.finishOrder();
    }

    public void sortProductsByPriceLowToHigh() {
        inventoryPage().sortPriceLowToHigh();
    }

    public void assertFirstProductPrice(String expectedPrice) {
        assertEquals(inventoryPage().firstProductPrice(), expectedPrice);
    }

    public void assertOrderConfirmation(String expectedMessage) {
        assertEquals(new CheckoutPage(driver()).confirmationMessage(), expectedMessage);
    }

    private LoginPage loginPage() {
        return new LoginPage(driver());
    }

    private InventoryPage inventoryPage() {
        return new InventoryPage(driver());
    }

    private WebDriver driver() {
        return BaseTest.currentDriver();
    }
}
