Certainly! Based on the provided blueprint and test cases, here is a complete Selenium WebDriver automation script in Java using TestNG and Cucumber. The script covers all the steps without repeating test scripts and follows best practices for maintainability and readability.

---

### Project Structure (Blueprint Summary)
- **Language:** Java
- **Test Framework:** TestNG
- **BDD Framework:** Cucumber
- **Automation Tool:** Selenium WebDriver
- **Dependencies:** Selenium, TestNG, Cucumber-Java, Cucumber-TestNG, WebDriverManager (for driver management)
- **Configuration:** `testng.xml` for TestNG suite, `cucumber.properties` or `cucumber.yml` for Cucumber options

---

### 1. Maven Dependencies (pom.xml snippet)
```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.9.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.0</version>
        <scope>test</scope>
    </dependency>

    <!-- Cucumber -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.11.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.11.0</version>
    </dependency>

    <!-- WebDriverManager for driver binaries -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.3.2</version>
    </dependency>
</dependencies>
```

---

### 2. Feature File (`src/test/resources/features/SwagLabs.feature`)
```gherkin
Feature: Swag Labs E2E Purchase Flow

  Scenario: User logs in, adds product to cart, and completes checkout
    Given User is on the Swag Labs login page
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks on login button
    Then User adds "Sauce Labs Bike Light" to the cart
    And User clicks on the cart icon with item count "1"
    And User clicks on checkout button
    And User enters first name "Satish"
    And User enters last name "Bedi"
    And User enters postal code "382445"
    And User clicks on continue button
    And User clicks on finish button
    Then User should see order confirmation
```

---

### 3. Step Definitions (`src/test/java/steps/SwagLabsSteps.java`)
```java
package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class SwagLabsSteps {

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User is on the Swag Labs login page")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("User clicks on login button")
    public void user_clicks_login() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("User adds {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        // Map product name to xpath id suffix
        String productId = "";
        if (productName.equalsIgnoreCase("Sauce Labs Bike Light")) {
            productId = "sauce-labs-bike-light";
        } else {
            throw new IllegalArgumentException("Product not recognized: " + productName);
        }
        driver.findElement(By.xpath("//button[@id='add-to-cart-" + productId + "']")).click();
    }

    @Then("User clicks on the cart icon with item count {string}")
    public void user_clicks_cart_icon(String itemCount) {
        // The cart icon shows the number of items in a span
        String cartCountXpath = "//span[normalize-space()='" + itemCount + "']";
        driver.findElement(By.xpath(cartCountXpath)).click();
    }

    @Then("User clicks on checkout button")
    public void user_clicks_checkout() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("User enters first name {string}")
    public void user_enters_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
    }

    @Then("User enters last name {string}")
    public void user_enters_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
    }

    @Then("User enters postal code {string}")
    public void user_enters_postal_code(String postalCode) {
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalCode);
    }

    @Then("User clicks on continue button")
    public void user_clicks_continue() {
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @Then("User clicks on finish button")
    public void user_clicks_finish() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @Then("User should see order confirmation")
    public void user_should_see_order_confirmation() {
        // Verify order confirmation page by checking for a confirmation message
        String confirmationXpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]";
        boolean isDisplayed = driver.findElement(By.xpath(confirmationXpath)).isDisplayed();
        Assert.assertTrue(isDisplayed, "Order confirmation message is not displayed.");
    }
}
```

---

### 4. Test Runner (`src/test/java/runners/TestRunner.java`)
```java
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

---

### 5. TestNG Suite XML (`testng.xml`)
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="SwagLabsSuite">
    <test name="SwagLabsTests">
        <classes>
            <class name="runners.TestRunner"/>
        </classes>
    </test>
</suite>
```

---

### How to Run
- Run the TestNG suite (`testng.xml`) or run the `TestRunner` class as TestNG test.
- The script will open Chrome, perform the login, add product to cart, checkout, and verify order confirmation.

---

### Notes
- WebDriverManager automatically manages the ChromeDriver binary.
- XPath locators are used exactly as provided.
- No test steps are repeated; each step corresponds to a unique action.
- The product name to button ID mapping is extensible.
- Assertions verify the final confirmation to ensure test validity.

---

If you want me to generate the full Maven project or additional utilities (like Page Object Model), please let me know!