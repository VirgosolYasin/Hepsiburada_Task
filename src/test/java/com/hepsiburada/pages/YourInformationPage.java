package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
    public YourInformationPage() {PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(id = "first-name")
    public WebElement input_firstName;

    @FindBy(id = "last-name")
    public WebElement input_lastName;

    @FindBy(id = "postal-code")
    public WebElement input_zipCode;

    @FindBy(id = "continue")
    public WebElement btn_continue;
}
