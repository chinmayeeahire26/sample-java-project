public class FlipkartLoginTest {
    public void loginToFlipkart() {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");

        // Close the login popup if it appears
        try {
            WebElement closeButton = driver.findElement(By.xpath("//button[text()='✕']"));
            closeButton.click();
        } catch (NoSuchElementException e) {
            // No popup appeared, continue
        }

        // Locate and fill in the username
        WebElement usernameField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
        usernameField.sendKeys("your_username");

        // Locate and fill in the password
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("your_password");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Add assertions to verify login success
        // Example: Assert.assertTrue(driver.getTitle().contains("Flipkart"));

        // Clean up
        driver.quit();
    }
}