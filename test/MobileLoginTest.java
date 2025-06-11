import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public MobileLoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void loginTest() {
        // Navigate to login page
        driver.get("https://example.com/login");

        // Locate username field and enter username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("testuser");

        // Locate password field and enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        // Locate and click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify login success
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
        assert successMessage.getText().contains("Welcome, testuser");
    }
}