import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZomatoLoginTest {

    public void loginToZomato() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Zomato login page
            driver.get("https://www.zomato.com/login");

            // Locate and fill the email field
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("your-email@example.com");

            // Locate and fill the password field
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("your-password");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Check if the user is redirected to the homepage
            // Assert.assertTrue(driver.getCurrentUrl().contains("homepage"));

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}