package com.hepsiburada.utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;


import java.time.Duration;
import java.util.List;

public class BrowserUtils {

    public static WebElement waitforvisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void wait(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void sendKey(WebElement element, String text) {
        waitforvisibility(element, 20);
        element.sendKeys(text);
    }

    public static void clickElement(WebElement element) {
        waitforvisibility(element, 20);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});", element);
        element.click();
    }

    public static void clickTextElement(List<WebElement> elements, String text) {

        boolean flag = false;
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
                flag=true;
                break;
            }
        }
        assertTrue(text+" text'li element bulunamadi.",flag);
    }

    public static void navigateBack(){
        Driver.getDriver().navigate().back();
    }

    public static void checkTextEqualTo(WebElement element, String expectedText) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});", element);
        assertEquals("Text esit degil.", expectedText, element.getText());

    }
}
