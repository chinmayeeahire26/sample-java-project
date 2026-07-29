Certainly! Below is a Selenium WebDriver automation script in Java using TestNG based on the provided details:

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebOrdersLoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Navigate to the Web Orders login page
        driver.get("http://your-weborders-url.com"); // Replace with actual URL
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        // Enter username "Tester"
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameField.sendKeys("Tester");

        // Enter password "test"
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordField.sendKeys("test");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        // Optionally, add assertions here to verify successful login
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

**Notes:**
- Replace `"path/to/chromedriver"` with the actual path to your ChromeDriver executable.
- Replace `"http://your-weborders-url.com"` with the actual URL of the Web Orders login page.
- You can add assertions after login to verify the success of the login operation.
- Make sure to add Selenium and TestNG dependencies to your project.