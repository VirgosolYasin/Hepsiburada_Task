package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.tinylog.Logger;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static void LOG(String message){
        Logger.info(message);
    }
}
