package com.hepsiburada.stepDefinitions;

import com.hepsiburada.pages.*;
import com.hepsiburada.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static com.hepsiburada.pages.BasePage.LOG;
import static org.junit.Assert.*;
import static com.hepsiburada.utilities.BrowserUtils.*;

public class WebStepDefinitions {
    Map<String, Double> products = new HashMap<>();

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    YourInformationPage yourInformationPage = new YourInformationPage();
    OverviewPage overviewPage = new OverviewPage();

    @Given("User navigate to {string}")
    public void user_navigate_to(String website) {
        LOG("User navigating to " + website);
        Driver.getDriver().get(website);
        LOG("User navigated to " + website);
    }

    @Then("wait {int}")
    public void wait(Integer duration) {
        LOG("Waiting " + duration + " seconds.");
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Verify url is {string}")
    public void verify_url_is(String website) {
        LOG("Verifying URL is " + website);
        assertEquals("URL is not equal.", Driver.getDriver().getCurrentUrl(), website);
        LOG("URL verified.");

    }

    @Then("Verify title is {string}")
    public void verify_title_is(String title) {
        LOG("Verifying page title is " + title);
        checkTextEqualTo(loginPage.txt_title, title);
        LOG("Page title verified.");
    }

    @When("Enter {string} into username")
    public void enter_into_username(String userName) {
        LOG("Sending username: " + userName);
        sendKey(loginPage.inputbox_userName, userName);
        LOG("Username  sent.");
    }

    @When("Enter {string} into password")
    public void enter_into_password(String password) {
        LOG("Sending password." + password);
        sendKey(loginPage.inputbox_password, password);
        LOG("Password sent.");
    }

    @When("Click Login button")
    public void click_login_button() {
        LOG("Clicking login button.");
        clickElement(loginPage.btn_login);
        LOG("Clicked login button");
    }

    @When("Select {string} product")
    public void select_product(String product) {
        LOG("Clicking " + product + " product.");
        clickTextElement(homePage.txt_productName, product);
        LOG("Adding to chart: " + product);
        clickElement(homePage.btn_addToCart);
        LOG("Navigating to products page.");
        navigateBack();
    }

    @When("Click cart button")
    public void clickCartButton() {
        LOG("Clicking cart button.");
        clickElement(homePage.btn_shoppingCart);
        LOG("Clicked cart button");
    }

    @When("Save {string} product price at cart page")
    public void saveProductPriceAtCartPage(String productName) {
        LOG("Saving " + productName + " product price");
        double productPrice = cartPage.bringPrices(productName);
        products.put(productName, productPrice);
        LOG(productName + " Product price is saved as " + productPrice);
    }

    @When("Click checkout button")
    public void clickCheckoutButton() {
        LOG("Clicking checkout button.");
        clickElement(cartPage.btn_checkOut);
        LOG("Clicked checkout button");
    }

    @When("Enter {string} into first name")
    public void enterIntoFirstName(String name) {
        LOG("Entering " + name + " into first name input.");
        sendKey(yourInformationPage.input_firstName, name);
        LOG("Entered " + name + " into first name input.");
    }

    @When("Enter {string} into last name")
    public void enterIntoLastName(String lastName) {
        LOG("Entering " + lastName + " into last name input.");
        sendKey(yourInformationPage.input_lastName, lastName);
        LOG("Entered " + lastName + " into last name input.");
    }

    @When("Enter {string} into zip or postal code")
    public void enterIntoZipPostalCode(String zipCode) {
        LOG("Entering " + zipCode + " into zip code.");
        sendKey(yourInformationPage.input_zipCode, zipCode);
        LOG("Entered " + zipCode + " into zip code.");
    }

    @When("Click continue button")
    public void clickContinueButton() {
        LOG("Clicking continue button.");
        clickElement(yourInformationPage.btn_continue);
        LOG("Clicked continue button.");
    }

    @Then("Compare {string} product price with card page")
    public void compareProductPriceWithCardPage(String productName) {
        LOG("Asserting " + productName + " price with cart page price.");
        double expectedPrice = cartPage.bringPrices(productName);
        assertEquals(products.get(productName), expectedPrice, 0.0);
        LOG("Asserted " + productName + " price with cart page price.");
    }

    @When("Click finish button")
    public void clickFinishButton() {
        LOG("Clicking finish button.");
        clickElement(overviewPage.btn_finish);
        LOG("Clicked finish button.");
    }

    @Then("Verify {string} text is displayed on complete page")
    public void verifyTextIsDisplayedOnCompletePage(String text) {
        LOG("Verifying successful message is displayed on complete page.");
        checkTextEqualTo(overviewPage.txt_completeMessage, text);
        LOG("Verified that successful message is displayed on complete page.");

    }
}
