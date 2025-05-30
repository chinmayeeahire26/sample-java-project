import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEnvLogin {

    public void loginToTestEnv() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the test environment URL
        driver.get("http://test-env-url.com");

        // Locate the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        // Locate the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");

        // Locate the login button and click it
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Add assertions or further actions as needed

        // Close the browser
        driver.quit();
    }
}