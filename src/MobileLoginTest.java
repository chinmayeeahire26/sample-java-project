public class MobileLoginTest {
    public void loginToMobile() {
        // Initialize mobile driver
        MobileDriver driver = new MobileDriver();
        driver.launchApp();

        // Locate and interact with login elements
        MobileElement usernameField = driver.findElement(By.id("username"));
        MobileElement passwordField = driver.findElement(By.id("password"));
        MobileElement loginButton = driver.findElement(By.id("loginButton"));

        // Perform login action
        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPassword");
        loginButton.click();

        // Validate login success
        MobileElement homeScreen = driver.findElement(By.id("homeScreen"));
        assertTrue(homeScreen.isDisplayed(), "Login was not successful");

        // Close the app
        driver.quit();
    }
}