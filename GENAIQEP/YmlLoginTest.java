public class YmlLoginTest {
    public void loginToYml() {
        // Initialize WebDriver (assuming ChromeDriver and WebDriverManager are configured in blueprint)
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to the login page URL from configuration
            String loginUrl = Config.get("login.url");
            driver.get(loginUrl);

            // Locate username and password fields and login button using selectors from blueprint
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginBtn"));

            // Enter credentials from configuration
            usernameField.sendKeys(Config.get("login.username"));
            passwordField.sendKeys(Config.get("login.password"));

            // Click login button
            loginButton.click();

            // Wait and verify successful login (e.g., presence of logout button or dashboard element)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));

            // Optionally assert login success
            Assert.assertTrue(driver.findElement(By.id("dashboard")).isDisplayed());
        } finally {
            // Clean up
            driver.quit();
        }
    }
}