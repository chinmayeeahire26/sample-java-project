Certainly! Below is a sample Java automation script using Selenium WebDriver and TestNG based on the provided blueprint and test cases. The script covers entering the username and password, then clicking the login button on the Swag Labs login page. It assumes you have the necessary dependencies and configurations set up in your project (e.g., Selenium WebDriver, TestNG).

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagLabsLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your chromedriver executable if not set in system PATH
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to Swag Labs login page
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest() {
        // Locate username field and enter "standard_user"
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        // Locate password field and enter "secret_sauce"
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("secret_sauce");

        // Locate login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        // Optionally, add assertions here to verify successful login
        // For example, check if the URL changed or a certain element is visible
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

### Notes:
- Replace `"path/to/chromedriver"` with the actual path to your ChromeDriver executable or ensure it's in your system PATH.
- The script uses TestNG annotations for setup (`@BeforeClass`), test execution (`@Test`), and teardown (`@AfterClass`).
- You can add assertions after clicking the login button to verify the login was successful.
- This script does not repeat test steps and follows the blueprint instructions.

If you need the script in another language or framework, please let me know!