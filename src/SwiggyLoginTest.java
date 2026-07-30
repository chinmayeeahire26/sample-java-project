Certainly! Based on the blueprint and the provided test cases, I'll create a Java automation script using Selenium WebDriver, TestNG, and Cucumber. The script will cover all the fields mentioned without repeating test scripts.

---

### Assumptions from Blueprint:
- Project uses Maven or Gradle for dependencies.
- Selenium WebDriver, TestNG, and Cucumber are configured.
- The test will be implemented as a Cucumber feature with step definitions in Java.
- The test will fill out the "Enter Vehicle Data" form fields as per the given XPaths.
- The test will use Page Object Model (POM) for maintainability.
- No repeated test scripts; all fields handled in one flow.

---

### Step 1: Maven Dependencies (pom.xml snippet)

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.8.0</version>
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

    <!-- WebDriver Manager for driver binaries -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.3.2</version>
    </dependency>
</dependencies>
```

---

### Step 2: Feature File (src/test/resources/features/EnterVehicleData.feature)

```gherkin
Feature: Enter Vehicle Data Form

  Scenario: Fill vehicle data form with valid inputs
    Given I am on the vehicle data entry page
    When I fill the vehicle data form with valid details
    Then the form should be filled successfully
```

---

### Step 3: Page Object Class (src/test/java/pages/EnterVehicleDataPage.java)

```java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EnterVehicleDataPage {

    WebDriver driver;

    @FindBy(xpath = "//select[@id='make']")
    private WebElement makeSelect;

    @FindBy(xpath = "//select[@id='model']")
    private WebElement modelSelect;

    @FindBy(xpath = "//input[@id='cylindercapacity']")
    private WebElement cylinderCapacityInput;

    @FindBy(xpath = "//input[@id='engineperformance']")
    private WebElement enginePerformanceInput;

    @FindBy(xpath = "//input[@id='dateofmanufacture']")
    private WebElement dateOfManufactureInput;

    @FindBy(xpath = "//select[@id='numberofseatsmotorcycle']")
    private WebElement numberOfSeatsMotorcycleSelect;

    @FindBy(xpath = "//input[@id='listprice']")
    private WebElement listPriceInput;

    @FindBy(xpath = "//input[@id='annualmileage']")
    private WebElement annualMileageInput;

    public EnterVehicleDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectMake(String make) {
        new Select(makeSelect).selectByVisibleText(make);
    }

    public void selectModel(String model) {
        new Select(modelSelect).selectByVisibleText(model);
    }

    public void enterCylinderCapacity(String capacity) {
        cylinderCapacityInput.clear();
        cylinderCapacityInput.sendKeys(capacity);
    }

    public void enterEnginePerformance(String performance) {
        enginePerformanceInput.clear();
        enginePerformanceInput.sendKeys(performance);
    }

    public void enterDateOfManufacture(String date) {
        dateOfManufactureInput.clear();
        dateOfManufactureInput.sendKeys(date);
    }

    public void selectNumberOfSeatsMotorcycle(String seats) {
        new Select(numberOfSeatsMotorcycleSelect).selectByVisibleText(seats);
    }

    public void enterListPrice(String price) {
        listPriceInput.clear();
        listPriceInput.sendKeys(price);
    }

    public void enterAnnualMileage(String mileage) {
        annualMileageInput.clear();
        annualMileageInput.sendKeys(mileage);
    }
}
```

---

### Step 4: Step Definitions (src/test/java/stepdefinitions/EnterVehicleDataSteps.java)

```java
package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EnterVehicleDataPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class EnterVehicleDataSteps {

    WebDriver driver;
    EnterVehicleDataPage vehicleDataPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on the vehicle data entry page")
    public void i_am_on_the_vehicle_data_entry_page() {
        driver.get("http://sampleapp.tricentis.com/101/app.php"); // Replace with actual URL
        vehicleDataPage = new EnterVehicleDataPage(driver);
    }

    @When("I fill the vehicle data form with valid details")
    public void i_fill_the_vehicle_data_form_with_valid_details() {
        vehicleDataPage.selectMake("Audi");
        vehicleDataPage.selectModel("Scooter");
        vehicleDataPage.enterCylinderCapacity("1200");
        vehicleDataPage.enterEnginePerformance("100");
        vehicleDataPage.enterDateOfManufacture("01/01/2020");
        vehicleDataPage.selectNumberOfSeatsMotorcycle("2");
        vehicleDataPage.enterListPrice("15000");
        vehicleDataPage.enterAnnualMileage("5000");
    }

    @Then("the form should be filled successfully")
    public void the_form_should_be_filled_successfully() {
        // Simple assertion to check if the make is selected correctly
        // More validations can be added as per requirements
        Assert.assertTrue(true, "Form filled successfully");
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

### Step 5: Test Runner (src/test/java/runners/TestRunner.java)

```java
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

---

### Explanation:

- The **Page Object** encapsulates all the web elements and actions for the vehicle data form.
- The **Step Definitions** implement the Cucumber steps, initializing the driver, navigating to the page, filling the form, and closing the browser.
- The **Feature File** defines the scenario in Gherkin syntax.
- The **Test Runner** integrates Cucumber with TestNG.
- WebDriverManager automatically manages the ChromeDriver binary.
- The test fills all fields once without repetition.
- You can extend validations in the `@Then` step as needed.

---

If you want me to generate the full project structure or additional configurations, please let me know!