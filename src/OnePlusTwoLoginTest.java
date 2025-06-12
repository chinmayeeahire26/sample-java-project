import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class OnePlusTwoLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Given("^user is on the login page$")
    public void userIsOnLoginPage() {
        driver.get("https://www.oneplustwo.com/login");
    }

    @Test
    @When("^user enters valid credentials$")
    public void userEntersValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("validUsername");
        passwordField.sendKeys("validPassword");
    }

    @Test
    @Then("^user is redirected to the dashboard$")
    public void userIsRedirectedToDashboard() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        // Add assertion to verify redirection
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}