import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AmazonLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Given("user is on Amazon login page")
    public void userIsOnAmazonLoginPage() {
        driver.get("https://www.amazon.com/ap/signin");
    }

    @Test
    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("user@example.com");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("password123");

        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
    }

    @Test
    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));
        assert accountElement.getText().contains("Hello, User");
    }

    @AfterClassimport org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AmazonLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Given("user is on Amazon login page")
    public void userIsOnAmazonLoginPage() {
        driver.get("https://www.amazon.com/ap/signin");
    }

    @Test
    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("user@example.com");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("password123");

        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
    }

    @Test
    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));
        assert accountElement.getText().contains("Hello, User");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

}
