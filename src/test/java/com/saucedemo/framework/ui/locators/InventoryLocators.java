package com.saucedemo.framework.ui.locators;

import org.openqa.selenium.By;

public final class InventoryLocators {
    public static final By TITLE = By.cssSelector(".title");
    public static final By CART_LINK = By.cssSelector(".shopping_cart_link");
    public static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    public static final By SORT_DROPDOWN = By.cssSelector("[data-test='product-sort-container']");
    public static final By FIRST_PRODUCT_PRICE = By.cssSelector(".inventory_item_price");

    private InventoryLocators() {
    }

    public static By addToCartButton(String productName) {
        return By.xpath("//div[contains(@class,'inventory_item')][.//div[contains(@class,'inventory_item_name') and normalize-space()="
                + xpathLiteral(productName) + "]]//button");
    }

    public static By productName(String productName) {
        return By.xpath("//div[contains(@class,'inventory_item_name') and normalize-space()="
                + xpathLiteral(productName) + "]");
    }

    private static String xpathLiteral(String value) {
        if (!value.contains("'")) {
            return "'" + value + "'";
        }
        if (!value.contains("\"")) {
            return "\"" + value + "\"";
        }
        String[] parts = value.split("'", -1);
        StringBuilder literal = new StringBuilder("concat(");
        for (int index = 0; index < parts.length; index++) {
            if (index > 0) {
                literal.append(", \"'\", ");
            }
            literal.append("'").append(parts[index]).append("'");
        }
        return literal.append(")").toString();
    }
}
