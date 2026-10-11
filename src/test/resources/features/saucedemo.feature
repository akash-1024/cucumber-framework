Feature: SauceDemo shopping experience
  As a SauceDemo customer
  I want to sign in and shop for products
  So that I can complete an order

  Scenario: Log in with valid credentials
    Given the SauceDemo login page is open
    When I log in as "standard_user" with password "secret_sauce"
    Then I should see the products page

  Scenario: Show an error for invalid credentials
    Given the SauceDemo login page is open
    When I log in as "invalid_user" with password "wrong_password"
    Then I should see the login error "Username and password do not match any user in this service"

  Scenario: Add a product to the shopping cart
    Given I am logged in to SauceDemo as "standard_user"
    When I add "Sauce Labs Backpack" to the cart
    Then the cart should contain "Sauce Labs Backpack"

  Scenario: Complete the checkout process
    Given I am logged in to SauceDemo as "standard_user"
    When I purchase "Sauce Labs Backpack" as "Jane" "Doe" with postal code "10001"
    Then the order confirmation should be "Thank you for your order!"

  Scenario: Sort products by price from low to high
    Given I am logged in to SauceDemo as "standard_user"
    When I sort products by price from low to high
    Then the first product should cost "$7.99"
