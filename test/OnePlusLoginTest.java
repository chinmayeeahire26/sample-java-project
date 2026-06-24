Certainly! Below is an automation script based on the provided details using Selenium WebDriver, Java, TestNG, and Cucumber.

### Cucumber Feature File (`WebOrdersLogin.feature`)
```gherkin
Feature: Web Orders Login

  Scenario: Login to Web Orders
    Given I open the Web Orders login page
    When I enter "Tester" as the username
    And I enter "test" as the password
    And I click the login button
    Then I should be logged in successfully
```

### Step Definitions (`WebOrdersLoginSteps.java`)
```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class WebOrdersLoginSteps {
    WebDriver driver;

    @Given("I open the Web Orders login page")
    public void i_open_the_web_orders_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://your-web-orders-url.com/login");
    }

    @When("I enter {string} as the username")
    public void i_enter_as_the_username(String username) {
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys(username);
    }

    @When("I enter {string} as the password")
    public void i_enter_as_the_password(String password) {
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Add assertion to verify successful login
        // Example: Assert.assertTrue(driver.findElement(By.xpath("//your-success-element")).isDisplayed());
        driver.quit();
    }
}
```

### TestNG Runner Class (`TestRunner.java`)
```java
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinitions",
    plugin = { "pretty", "html:target/cucumber-reports.html" }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

### Maven `pom.xml` (if you are using Maven)
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>web-orders-automation</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- Selenium WebDriver -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>

        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.4.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.10.4</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>6.10.4</version>
        </dependency>
    </dependencies>
</project>
```

### Directory Structure
```
src
└── test
    ├── java
    │   └── stepdefinitions
    │       └── WebOrdersLoginSteps.java
    └── resources
        └── features
            └── WebOrdersLogin.feature
pom.xml
```

Make sure to replace `"path/to/chromedriver"` and `"http://your-web-orders-url.com/login"` with the actual paths and URLs. Also, update the success assertion in the step definition to match your application’s behavior after a successful login.