Feature: Web Scenarios

  @web @smoke
  Scenario: Web Scenarios
    Given User navigate to "https://www.saucedemo.com/"
    Then Verify url is "https://www.saucedemo.com/"
    When Enter "standard_user" into username
    When Enter "secret_sauce" into password
    When Click Login button
    Then Verify url is "https://www.saucedemo.com/inventory.html"
    Then Verify title is "Products"
    Then Select "Sauce Labs Backpack" product
    Then Select "Sauce Labs Bike Light" product
    When Click cart button
    Then Verify url is "https://www.saucedemo.com/cart.html"
    Then Verify title is "Your Cart"
    When Save "Sauce Labs Backpack" product price at cart page
    When Save "Sauce Labs Bike Light" product price at cart page
    When Click checkout button
    Then Verify url is "https://www.saucedemo.com/checkout-step-one.html"
    Then Verify title is "Checkout: Your Information"
    When Enter "Yasin" into first name
    When Enter "Test" into last name
    When Enter "35620" into zip or postal code
    When Click continue button
    Then Verify url is "https://www.saucedemo.com/checkout-step-two.html"
    Then Verify title is "Checkout: Overview"
    Then Compare "Sauce Labs Backpack" product price with card page
    Then Compare "Sauce Labs Bike Light" product price with card page
    When Click finish button
    Then Verify url is "https://www.saucedemo.com/checkout-complete.html"
    Then Verify title is "Checkout: Complete!"
    Then Verify "Your order has been dispatched, and will arrive just as fast as the pony can get there!" text is displayed on complete page
