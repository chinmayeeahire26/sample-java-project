```java
// Automation script for Web Orders Login using Selenium WebDriver, Java, TestNG, and Cucumber

// Feature file: WebOrdersLogin.feature
/*
Feature: Web Orders Login

  Scenario: Successful login with valid credentials
    Given User is on the Web Orders login page
    When User enters username "Tester"
    And User enters password "test"
    And User clicks on the login button
    Then User should be logged in successfully
*/

// Step Definitions: WebOrdersLoginSteps.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class WebOrdersLoginSteps {

    WebDriver driver;

    @Given("User is on the Web Orders login page")
    public void user_is_on_the_web_orders_login_page() {
        // Setup ChromeDriver path accordingly
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://example.com/weborders/login"); // Replace with actual URL
        driver.manage().window().maximize();
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys(password);
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Add validation logic here, e.g., check for a logout button or welcome message
        boolean isLoggedIn = driver.findElements(By.id("logoutButton")).size() > 0;
        Assert.assertTrue(isLoggedIn, "Login failed - Logout button not found.");
        driver.quit();
    }
}

// TestNG Runner: TestRunner.java

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/WebOrdersLogin.feature",
    glue = {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```
This script uses the provided XPath locators and input values to automate the login process for the Web Orders application using Selenium WebDriver with Java, TestNG, and Cucumber. Adjust the ChromeDriver path and URL as needed.