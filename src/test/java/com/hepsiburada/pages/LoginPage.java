package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[data-test='title']")
    public WebElement txt_title;

    @FindBy(id = "user-name")
    public WebElement inputbox_userName;

    @FindBy(id = "password")
    public WebElement inputbox_password;

    @FindBy(id = "login-button")
    public WebElement btn_login;

}
