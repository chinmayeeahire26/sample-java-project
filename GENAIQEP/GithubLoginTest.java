import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GithubLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public GithubLoginTest() {
        // Assuming ChromeDriver path is set in system properties or environment variables
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToGithub(String username, String password) {
        driver.get("https://github.com/login");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field")));
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        // Wait for the user profile icon or dashboard to confirm login success
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("summary[aria-label='View profile and more']")));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // For demonstration purposes, a main method to run the test
    public static void main(String[] args) {
        GithubLoginTest test = new GithubLoginTest();
        try {
            test.loginToGithub("your_username", "your_password");
            System.out.println("Login successful");
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        } finally {
            test.tearDown();
        }
    }
}