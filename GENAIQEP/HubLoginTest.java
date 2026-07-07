public class HubLoginTest {
    public void logInToHub() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to Hub login page
            driver.get("https://hub.example.com/login");

            // Locate username and password fields and login button
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginBtn"));

            // Enter credentials
            usernameField.sendKeys("testuser");
            passwordField.sendKeys("testpassword");

            // Click login
            loginButton.click();

            // Wait for login to complete and verify successful login
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/dashboard"));

            // Optionally assert login success
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.contains("/dashboard")) {
                throw new AssertionError("Login failed, dashboard not reached.");
            }
        } finally {
            // Clean up
            driver.quit();
        }
    }
}