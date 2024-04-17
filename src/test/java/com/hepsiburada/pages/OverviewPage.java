package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    public OverviewPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "finish")
    public WebElement btn_finish;

    @FindBy(css = "[data-test = 'complete-text']")
    public WebElement txt_completeMessage;
}
