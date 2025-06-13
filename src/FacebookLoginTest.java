import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToFacebook() {
        // Navigate to Facebook
        driver.get("https://www.facebook.com");

        // Find the email input field and enter the email
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("your-email@example.com");

        // Find the password input field and enter the password
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("your-password");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        // Add assertions here to verify successful login
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}