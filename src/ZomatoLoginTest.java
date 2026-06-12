Certainly! Below is an automation script based on the provided details, using Selenium WebDriver with Java, TestNG, and Cucumber.

### Maven Dependencies
First, ensure you have the necessary dependencies in your `pom.xml`:

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version> <!-- Use the latest version -->
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version> <!-- Use the latest version -->
        <scope>test</scope>
    </dependency>
    
    <!-- Cucumber -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.x.x</version> <!-- Use the latest version -->
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.x.x</version>
    </dependency>
    
    <!-- JUnit (if needed for any reason) -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Cucumber Feature File
Create a feature file `Login.feature`:

```gherkin
Feature: Login to Swag Labs

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click on the login button
    Then I should be logged in successfully
```

### Step Definitions
Create step definitions in `LoginSteps.java`:

```java
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        driver.quit();
    }
}
```

### TestNG Runner
Create a TestNG runner class `TestRunner.java`:

```java
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "path.to.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

### Directory Structure
Ensure your directory structure looks something like this:
```
src
└── test
    ├── java
    │   └── path
    │       └── to
    │           └── stepdefinitions
    │               └── LoginSteps.java
    └── resources
        └── features
            └── Login.feature
```

### Execution
Run the `TestRunner` class using TestNG to execute your Cucumber scenarios.

This script will automate the login process for the Swag Labs website using the provided XPaths and input values.