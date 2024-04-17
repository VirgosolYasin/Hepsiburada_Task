package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "checkout")
    public WebElement btn_checkOut;

    public double bringPrices(String text) {
        String fullPath = "//*[@data-test=\"inventory-item-name\" and text()=\"" + text + "\"]/../..//div[@data-test='inventory-item-price']";
        return Double.parseDouble(Driver.getDriver().findElement(By.xpath(fullPath)).getText().replace("$", ""));
    }
}
