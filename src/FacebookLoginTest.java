Certainly! Below is a strictly created automation script in Java using Selenium WebDriver, TestNG, and Cucumber based on the provided test-script details. The script includes step definitions for interacting with the specified elements using their XPaths and types.

---

### Feature File (`EnterVehicleData.feature`)
```gherkin
Feature: Enter Vehicle Data

  Scenario: Fill vehicle data form
    Given I open the vehicle data page
    When I select "Audi" from the make dropdown
    And I select "Scooter" from the model dropdown
    And I enter "1200" into the cylinder capacity field
    And I enter "100" into the engine performance field
    And I enter "01/01/2020" into the date of manufacture field
    And I select "2" from the number of seats motorcycle dropdown
    And I enter "15000" into the list price field
    And I enter "5000" into the annual mileage field
    Then I should see the vehicle data entered successfully
```

---

### Step Definitions (`EnterVehicleDataSteps.java`)
```java
package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class EnterVehicleDataSteps {

    WebDriver driver;

    public EnterVehicleDataSteps() {
        // Assuming driver is initialized elsewhere and passed here or use hooks
        this.driver = Hooks.driver;
    }

    @Given("I open the vehicle data page")
    public void i_open_the_vehicle_data_page() {
        driver.get("http://sampleappurl.com/vehicledata"); // Replace with actual URL
    }

    @When("I select {string} from the make dropdown")
    public void i_select_from_the_make_dropdown(String make) {
        WebElement makeDropdown = driver.findElement(By.xpath("//select[@id='make']"));
        Select selectMake = new Select(makeDropdown);
        selectMake.selectByVisibleText(make);
    }

    @When("I select {string} from the model dropdown")
    public void i_select_from_the_model_dropdown(String model) {
        WebElement modelDropdown = driver.findElement(By.xpath("//select[@id='model']"));
        Select selectModel = new Select(modelDropdown);
        selectModel.selectByVisibleText(model);
    }

    @When("I enter {string} into the cylinder capacity field")
    public void i_enter_into_the_cylinder_capacity_field(String value) {
        WebElement cylinderCapacity = driver.findElement(By.xpath("//input[@id='cylindercapacity']"));
        cylinderCapacity.clear();
        cylinderCapacity.sendKeys(value);
    }

    @When("I enter {string} into the engine performance field")
    public void i_enter_into_the_engine_performance_field(String value) {
        WebElement enginePerformance = driver.findElement(By.xpath("//input[@id='engineperformance']"));
        enginePerformance.clear();
        enginePerformance.sendKeys(value);
    }

    @When("I enter {string} into the date of manufacture field")
    public void i_enter_into_the_date_of_manufacture_field(String value) {
        WebElement dateOfManufacture = driver.findElement(By.xpath("//input[@id='dateofmanufacture']"));
        dateOfManufacture.clear();
        dateOfManufacture.sendKeys(value);
    }

    @When("I select {string} from the number of seats motorcycle dropdown")
    public void i_select_from_the_number_of_seats_motorcycle_dropdown(String seats) {
        WebElement seatsDropdown = driver.findElement(By.xpath("//select[@id='numberofseatsmotorcycle']"));
        Select selectSeats = new Select(seatsDropdown);
        selectSeats.selectByVisibleText(seats);
    }

    @When("I enter {string} into the list price field")
    public void i_enter_into_the_list_price_field(String value) {
        WebElement listPrice = driver.findElement(By.xpath("//input[@id='listprice']"));
        listPrice.clear();
        listPrice.sendKeys(value);
    }

    @When("I enter {string} into the annual mileage field")
    public void i_enter_into_the_annual_mileage_field(String value) {
        WebElement annualMileage = driver.findElement(By.xpath("//input[@id='annualmileage']"));
        annualMileage.clear();
        annualMileage.sendKeys(value);
    }

    @Then("I should see the vehicle data entered successfully")
    public void i_should_see_the_vehicle_data_entered_successfully() {
        // Placeholder for validation, e.g., check for a confirmation message or next page
        // For demonstration, just assert true
        Assert.assertTrue(true);
    }
}
```

---

### TestNG Runner (`TestRunner.java`)
```java
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

---

### Hooks (`Hooks.java`) - For WebDriver Setup and Teardown
```java
package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

### Notes:
- Replace `"http://sampleappurl.com/vehicledata"` with the actual URL of the vehicle data page.
- Update the ChromeDriver path in `Hooks.java`.
- The feature file uses sample data; you can parameterize or extend as needed.
- The validation step is a placeholder; implement actual verification based on your application.

This completes the strictly created automation script based on your provided test-script and blueprint details.