package com.saucedemo.framework.ui.pages;

import com.saucedemo.framework.ui.locators.LoginLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void loginAs(String username, String password) {
        enterText(LoginLocators.USERNAME, username);
        enterText(LoginLocators.PASSWORD, password);
        click(LoginLocators.LOGIN_BUTTON);
    }

    public String errorMessage() {
        return textOf(LoginLocators.ERROR_MESSAGE);
    }

    public boolean isOpen() {
        return isVisible(LoginLocators.LOGIN_BUTTON);
    }
}
