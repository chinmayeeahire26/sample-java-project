public class MyntraLogoutTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver and navigate to Myntra
        driver = new ChromeDriver();
        driver.get("https://www.myntra.com");
    }

    @Test
    public void logoutFromMyntra() {
        // Assuming user is already logged in
        // Locate and click on the user profile icon
        WebElement profileIcon = driver.findElement(By.id("profile-icon-id"));
        profileIcon.click();

        // Locate and click on the logout button
        WebElement logoutButton = driver.findElement(By.id("logout-button-id"));
        logoutButton.click();

        // Verify logout by checking the presence of login button
        WebElement loginButton = driver.findElement(By.id("login-button-id"));
        Assert.assertTrue(loginButton.isDisplayed(), "Logout failed, login button not displayed.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}