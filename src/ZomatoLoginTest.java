Certainly! Below is an automation script created using Selenium WebDriver with Java, TestNG, and Cucumber based on the provided details.

### Cucumber Feature File: `swag_labs.feature`

```gherkin
Feature: Swag Labs E-commerce Automation

  Scenario: Login and Purchase a Product
    Given I open the Swag Labs login page
    When I enter "standard_user" as the username
    And I enter "secret_sauce" as the password
    And I click the login button
    Then I should be on the products page
    When I add the "Sauce Labs Bike Light" to the cart
    And I click on the cart icon showing "1" item
    Then I should be on the cart page
    When I click the "Checkout" button
    And I enter "Satish" as the first name
    And I enter "Bedi" as the last name
    And I enter "382445" as the postal code
    And I click the "Continue" button
    Then I should be on the checkout overview page
    When I click the "Finish" button
    Then I should see the order confirmation
```

### Step Definitions: `SwagLabsSteps.java`

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SwagLabsSteps {
    WebDriver driver;

    @Given("I open the Swag Labs login page")
    public void i_open_the_swag_labs_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter {string} as the username")
    public void i_enter_as_the_username(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
    }

    @When("I enter {string} as the password")
    public void i_enter_as_the_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("I should be on the products page")
    public void i_should_be_on_the_products_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @When("I add the {string} to the cart")
    public void i_add_the_to_the_cart(String productName) {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }

    @When("I click on the cart icon showing {string} item")
    public void i_click_on_the_cart_icon_showing_item(String itemCount) {
        driver.findElement(By.xpath("//span[normalize-space()='" + itemCount + "']")).click();
    }

    @Then("I should be on the cart page")
    public void i_should_be_on_the_cart_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonText) {
        if (buttonText.equals("Checkout")) {
            driver.findElement(By.xpath("//button[@id='checkout']")).click();
        } else if (buttonText.equals("Continue")) {
            driver.findElement(By.xpath("//input[@id='continue']")).click();
        } else if (buttonText.equals("Finish")) {
            driver.findElement(By.xpath("//button[@id='finish']")).click();
        }
    }

    @When("I enter {string} as the first name")
    public void i_enter_as_the_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
    }

    @When("I enter {string} as the last name")
    public void i_enter_as_the_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
    }

    @When("I enter {string} as the postal code")
    public void i_enter_as_the_postal_code(String postalCode) {
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalCode);
    }

    @Then("I should be on the checkout overview page")
    public void i_should_be_on_the_checkout_overview_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Then("I should see the order confirmation")
    public void i_should_see_the_order_confirmation() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        driver.quit();
    }
}
```

### TestNG Configuration: `testng.xml`

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="SwagLabsSuite" parallel="false">
    <test name="SwagLabsTest">
        <classes>
            <class name="path.to.SwagLabsSteps"/>
        </classes>
    </test>
</suite>
```

### Dependencies in `pom.xml`

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>

    <!-- Cucumber -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.x.x</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.x.x</version>
    </dependency>
</dependencies>
```

This script sets up an automation flow for logging in, adding a product to the cart, filling out checkout information, and completing the purchase on the Swag Labs demo site using Selenium WebDriver, Java, TestNG, and Cucumber.