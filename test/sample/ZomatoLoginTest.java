import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZomatoLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zomato.com");
    }

    @Test
    public void loginToZomato() {
        WebElement loginButton = driver.findElement(By.id("login-button-id"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.id("email-field-id"));
        emailField.sendKeys("your-email@example.com");

        WebElement passwordField = driver.findElement(By.id("password-field-id"));
        passwordField.sendKeys("your-password");

        WebElement submitButton = driver.findElement(By.id("submit-button-id"));
        submitButton.click();

        WebElement profileName = driver.findElement(By.id("profile-name-id"));
        Assert.assertEquals(profileName.getText(), "Expected Profile Name");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
