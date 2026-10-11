package com.saucedemo.framework.stepdefinitions;

import com.saucedemo.framework.business.SauceDemoBusinessSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoStepDefinitions {
    private final SauceDemoBusinessSteps businessSteps = new SauceDemoBusinessSteps();

    @Given("the SauceDemo login page is open")
    public void theLoginPageIsOpen() {
        businessSteps.openLoginPage();
    }

    @Given("I am logged in to SauceDemo as {string}")
    public void iAmLoggedIn(String username) {
        businessSteps.loginAsStandardUser(username);
        businessSteps.assertProductsPage();
    }

    @When("I log in as {string} with password {string}")
    public void iLogIn(String username, String password) {
        businessSteps.login(username, password);
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        businessSteps.assertProductsPage();
    }

    @Then("I should see the login error {string}")
    public void iShouldSeeTheLoginError(String expectedError) {
        businessSteps.assertLoginError(expectedError);
    }

    @When("I add {string} to the cart")
    public void iAddProductToCart(String productName) {
        businessSteps.addProductToCart(productName);
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String productName) {
        businessSteps.assertCartContains(productName);
    }

    @When("I purchase {string} as {string} {string} with postal code {string}")
    public void iPurchaseProduct(String productName, String firstName, String lastName, String postalCode) {
        businessSteps.purchaseProduct(productName, firstName, lastName, postalCode);
    }

    @Then("the order confirmation should be {string}")
    public void theOrderConfirmationShouldBe(String message) {
        businessSteps.assertOrderConfirmation(message);
    }

    @When("I sort products by price from low to high")
    public void iSortProductsByPriceLowToHigh() {
        businessSteps.sortProductsByPriceLowToHigh();
    }

    @Then("the first product should cost {string}")
    public void theFirstProductShouldCost(String price) {
        businessSteps.assertFirstProductPrice(price);
    }
}
