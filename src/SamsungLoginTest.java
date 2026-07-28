Certainly! Based on the provided blueprint and test cases, here is a complete Selenium WebDriver automation script in Java using TestNG and Cucumber. The script covers all the steps without repeating test scripts and follows best practices for maintainability.

---

### Project Structure (Blueprint Summary)
- **Language:** Java
- **Framework:** TestNG, Cucumber
- **Tools:** Selenium WebDriver
- **Dependencies:** Selenium Java, TestNG, Cucumber Java, Cucumber TestNG, WebDriverManager (for driver management)
- **Configuration:** TestNG XML for suite configuration, Cucumber feature files for BDD scenarios

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

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.3.2</version>
    </dependency>
</dependencies>
```

---

### 2. Feature File (`src/test/resources/features/swaglabs_login.feature`)
```gherkin
Feature: Swag Labs Purchase Flow

  Scenario: User logs in, adds product to cart, and completes checkout
    Given User is on the Swag Labs login page
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks on login button
    And User adds "Sauce Labs Bike Light" to the cart
    And User clicks on the cart icon
    And User clicks on checkout button
    And User enters first name "Satish"
    And User enters last name "Bedi"
    And User enters postal code "382445"
    And User clicks on continue button
    And User clicks on finish button
    Then The order should be completed successfully
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

    @When("User adds {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        // Mapping product name to xpath for add to cart button
        if (productName.equalsIgnoreCase("Sauce Labs Bike Light")) {
            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        } else {
            throw new IllegalArgumentException("Product not recognized: " + productName);
        }
    }

    @When("User clicks on the cart icon")
    public void user_clicks_cart_icon() {
        driver.findElement(By.xpath("//span[normalize-space()='1']")).click();
    }

    @When("User clicks on checkout button")
    public void user_clicks_checkout() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @When("User enters first name {string}")
    public void user_enters_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
    }

    @When("User enters last name {string}")
    public void user_enters_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
    }

    @When("User enters postal code {string}")
    public void user_enters_postal_code(String postalCode) {
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalCode);
    }

    @When("User clicks on continue button")
    public void user_clicks_continue() {
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @When("User clicks on finish button")
    public void user_clicks_finish() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @Then("The order should be completed successfully")
    public void verify_order_completion() {
        // Verify order completion by checking confirmation message or URL
        String confirmationText = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(confirmationText, "THANK YOU FOR YOUR ORDER");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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

### 5. TestNG XML Suite (`testng.xml`)
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="SwagLabs Test Suite">
    <test name="SwagLabs Purchase Test">
        <classes>
            <class name="runners.TestRunner"/>
        </classes>
    </test>
</suite>
```

---

### Explanation:
- The **feature file** describes the user journey in BDD style.
- The **step definitions** implement each step using Selenium WebDriver commands.
- The **TestRunner** integrates Cucumber with TestNG.
- The **TestNG XML** configures the test suite.
- WebDriverManager automatically manages the ChromeDriver binary.
- The script uses XPath locators exactly as provided.
- No test steps are repeated; each action is defined once and reused.
- The final assertion verifies the order completion message.

---

You can run the tests via your IDE or command line using Maven:

```bash
mvn clean test
```

This will execute the Cucumber scenario using TestNG and generate an HTML report.

Let me know if you need the script adapted for another language or framework!