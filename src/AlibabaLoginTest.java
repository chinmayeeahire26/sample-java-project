import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlibabaLoginTest {

    public void loginToAlibaba() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Alibaba login page
            driver.get("https://login.alibaba.com");

            // Locate and fill the username field
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("yourUsername");

            // Locate and fill the password field
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("yourPassword");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Check for a specific element that appears only after login
            WebElement profileElement = driver.findElement(By.id("profile"));
            assert profileElement.isDisplayed();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}