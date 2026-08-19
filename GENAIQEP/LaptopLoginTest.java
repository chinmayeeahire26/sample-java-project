public class LaptopLoginTest {
    public void loginToLaptop1() {
        // Initialize WebDriver or relevant driver based on blueprint
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to the login page
            driver.get("http://laptop1-login-url.com");

            // Locate username field and enter username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("yourUsername");

            // Locate password field and enter password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("yourPassword");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Add verification/assertion to confirm login success
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("dashboard"));

            System.out.println("Login to Laptop1 successful.");
        } finally {
            // Clean up and close the driver
            driver.quit();
        }
    }
}