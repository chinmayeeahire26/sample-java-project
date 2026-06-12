Certainly! Below is an automation script based on the provided blueprint and test cases using Selenium WebDriver with Java, TestNG, and Cucumber.

### Feature File: `SwagLabs.feature`

```gherkin
Feature: Swag Labs E-commerce Automation

  Scenario: User login and purchase a product
    Given the user is on the Swag Labs login page
    When the user enters "standard_user" as the username
    And the user enters "secret_sauce" as the password
    And the user clicks on the login button
    Then the user should be on the products page
    When the user adds a product to the cart
    And the user clicks on the cart icon
    And the user clicks on the checkout button
    Then the user should be on the checkout page
    When the user enters "Satish" as the first name
    And the user enters "Bedi" as the last name
    And the user enters "382445" as the postal code
    And the user clicks on the continue button
    Then the user should be on the overview page
    When the user clicks on the finish button
    Then the order should be completed
```

### Step Definitions: `SwagLabsSteps.java`

```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SwagLabsSteps {
    WebDriver driver;

    @Given("the user is on the Swag Labs login page")
    public void the_user_is_on_the_swag_labs_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters {string} as the username")
    public void the_user_enters_as_the_username(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
    }

    @And("the user enters {string} as the password")
    public void the_user_enters_as_the_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("the user should be on the products page")
    public void the_user_should_be_on_the_products_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }

    @And("the user clicks on the cart icon")
    public void the_user_clicks_on_the_cart_icon() {
        driver.findElement(By.xpath("//span[normalize-space()='1']")).click();
    }

    @And("the user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("the user should be on the checkout page")
    public void the_user_should_be_on_the_checkout_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    @When("the user enters {string} as the first name")
    public void the_user_enters_as_the_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
    }

    @And("the user enters {string} as the last name")
    public void the_user_enters_as_the_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
    }

    @And("the user enters {string} as the postal code")
    public void the_user_enters_as_the_postal_code(String postalCode) {
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalCode);
    }

    @And("the user clicks on the continue button")
    public void the_user_clicks_on_the_continue_button() {
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @Then("the user should be on the overview page")
    public void the_user_should_be_on_the_overview_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @When("the user clicks on the finish button")
    public void the_user_clicks_on_the_finish_button() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @Then("the order should be completed")
    public void the_order_should_be_completed() {
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
            <class name="stepDefinitions.SwagLabsSteps"/>
        </classes>
    </test>
</suite>
```

### Project Structure

```
src
├── main
│   └── java
│       └── stepDefinitions
│           └── SwagLabsSteps.java
└── test
    └── resources
        └── SwagLabs.feature
        └── testng.xml
```

### Dependencies (Maven `pom.xml`)

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
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

This script covers all the necessary steps for logging in, adding a product to the cart, and completing the checkout process as per the given test cases.