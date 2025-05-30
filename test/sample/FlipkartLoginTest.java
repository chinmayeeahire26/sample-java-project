import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Flipkart login page
            driver.get("https://www.flipkart.com");

            // Locate and interact with login elements
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            // Enter credentials
            usernameField.sendKeys("your_username");
            passwordField.sendKeys("your_password");

            // Click login button
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Assert that the user is redirected to the homepage
            // Assert.assertTrue(driver.getCurrentUrl().contains("homepage"));

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
}