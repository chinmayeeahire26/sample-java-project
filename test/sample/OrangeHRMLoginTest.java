import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

    public void loginToOrangeHRM() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the OrangeHRM login page
            driver.get("https://example.orangehrm.com");

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            WebElement passwordField = driver.findElement(By.id("txtPassword"));

            // Enter the username and password
            usernameField.sendKeys("yourUsername");
            passwordField.sendKeys("yourPassword");

            // Click the login button
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Check if the dashboard is displayed
            WebElement dashboard = driver.findElement(By.id("dashboard"));
            assert(dashboard.isDisplayed());

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
}