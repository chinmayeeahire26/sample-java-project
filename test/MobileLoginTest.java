public class AjioLoginTest {
    public void loginUser() {
        // Navigate to login page
        driver.get("https://www.ajio.com/login");
        // Enter username
        driver.findElement(By.id("username")).sendKeys("testuser");
        // Enter password
        driver.findElement(By.id("password")).sendKeys("password123");
        // Click login button
        driver.findElement(By.id("loginButton")).click();
        // Verify login success
        String expectedUrl = "https://www.ajio.com/home";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}