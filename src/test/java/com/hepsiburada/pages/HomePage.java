package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-test=\"inventory-item-name\"]")
    public List<WebElement> txt_productName;

    @FindBy(id = "add-to-cart")
    public WebElement btn_addToCart;

    @FindBy(id = "shopping_cart_container")
    public WebElement btn_shoppingCart;
}
