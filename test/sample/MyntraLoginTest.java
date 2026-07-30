Certainly! Below is a strictly created automation script in Java using Selenium WebDriver, TestNG, and Cucumber based on the provided test-script details. This script focuses on the "Enter Vehicle Data" form fields with the specified XPaths and types.

---

### 1. Feature File (`EnterVehicleData.feature`)

```gherkin
Feature: Enter Vehicle Data Form

  Scenario: Fill vehicle data form fields
    Given I am on the vehicle data entry page
    When I select "Audi" from the Make dropdown
    And I select "Scooter" from the Model dropdown
    And I enter "1200" into Cylinder Capacity
    And I enter "150" into Engine Performance
    And I enter "01/01/2020" into Date of Manufacture
    And I select "2" from Number of Seats Motorcycle dropdown
    And I enter "15000" into List Price
    And I enter "5000" into Annual Mileage
    Then I verify the vehicle data form is filled correctly
```

---

### 2. Step Definitions (`EnterVehicleDataSteps.java`)

```java
package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverFactory;

public class EnterVehicleDataSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the vehicle data entry page")
    public void i_am_on_the_vehicle_data_entry_page() {
        driver.get("http://sampleappurl.com/vehicledata"); // Replace with actual URL
    }

    @When("I select {string} from the Make dropdown")
    public void i_select_from_the_make_dropdown(String make) {
        Select makeDropdown = new Select(driver.findElement(By.xpath("//select[@id='make']")));
        makeDropdown.selectByVisibleText(make);
    }

    @When("I select {string} from the Model dropdown")
    public void i_select_from_the_model_dropdown(String model) {
        Select modelDropdown = new Select(driver.findElement(By.xpath("//select[@id='model']")));
        modelDropdown.selectByVisibleText(model);
    }

    @When("I enter {string} into Cylinder Capacity")
    public void i_enter_into_cylinder_capacity(String value) {
        driver.findElement(By.xpath("//input[@id='cylindercapacity']")).clear();
        driver.findElement(By.xpath("//input[@id='cylindercapacity']")).sendKeys(value);
    }

    @When("I enter {string} into Engine Performance")
    public void i_enter_into_engine_performance(String value) {
        driver.findElement(By.xpath("//input[@id='engineperformance']")).clear();
        driver.findElement(By.xpath("//input[@id='engineperformance']")).sendKeys(value);
    }

    @When("I enter {string} into Date of Manufacture")
    public void i_enter_into_date_of_manufacture(String value) {
        driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).clear();
        driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys(value);
    }

    @When("I select {string} from Number of Seats Motorcycle dropdown")
    public void i_select_from_number_of_seats_motorcycle_dropdown(String seats) {
        Select seatsDropdown = new Select(driver.findElement(By.xpath("//select[@id='numberofseatsmotorcycle']")));
        seatsDropdown.selectByVisibleText(seats);
    }

    @When("I enter {string} into List Price")
    public void i_enter_into_list_price(String value) {
        driver.findElement(By.xpath("//input[@id='listprice']")).clear();
        driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys(value);
    }

    @When("I enter {string} into Annual Mileage")
    public void i_enter_into_annual_mileage(String value) {
        driver.findElement(By.xpath("//input[@id='annualmileage']")).clear();
        driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys(value);
    }

    @Then("I verify the vehicle data form is filled correctly")
    public void i_verify_the_vehicle_data_form_is_filled_correctly() {
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='make']"))).getFirstSelectedOption().getText(), "Audi");
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='model']"))).getFirstSelectedOption().getText(), "Scooter");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='cylindercapacity']")).getAttribute("value"), "1200");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='engineperformance']")).getAttribute("value"), "150");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).getAttribute("value"), "01/01/2020");
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='numberofseatsmotorcycle']"))).getFirstSelectedOption().getText(), "2");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='listprice']")).getAttribute("value"), "15000");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualmileage']")).getAttribute("value"), "5000");
    }
}
```

---

### 3. Test Runner (`TestRunner.java`)

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

### 4. Driver Factory (`DriverFactory.java`)

```java
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update path
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
```

---

### 5. TestNG XML (`testng.xml`)

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="VehicleDataSuite">
    <test name="VehicleDataTest">
        <classes>
            <class name="runners.TestRunner"/>
        </classes>
    </test>
</suite>
```

---

### Notes:
- Replace `"http://sampleappurl.com/vehicledata"` with the actual URL of the vehicle data entry page.
- Update the ChromeDriver path in `DriverFactory.java`.
- The sample test script values (e.g., "Audi", "Scooter", "1200") are placeholders and can be parameterized or replaced as needed.
- This setup uses Cucumber with TestNG integration.
- The verification step asserts that the form fields contain the expected values after input.

If you want me to generate Maven dependencies or any other supporting files, please let me know!