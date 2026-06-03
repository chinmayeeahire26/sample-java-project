```java
package com.swaglabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.cucumber.java.en.*;

public class SwagLabsTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set path to chromedriver executable if needed
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void swagLabsLoginAndCheckout() throws InterruptedException {
        // Login Page
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Products Page
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='1']")).click();

        // Your Cart Page
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        // Checkout Page
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Satish");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Bedi");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("382445");
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        // Overview Page
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        // Optional: Add assertions here to verify successful checkout
    }
}
```

---

### Explanation:
- **Selenium WebDriver** is used to automate browser interactions.
- **TestNG** framework is used to structure the test with `@BeforeClass`, `@Test`, and `@AfterClass` annotations.
- The script follows the exact steps from the provided test script:
  - Login with username and password.
  - Add product to cart.
  - Proceed to checkout and fill in user details.
  - Finish the order.
- Replace `"path/to/chromedriver"` with the actual path to your ChromeDriver executable.
- You can extend this with Cucumber feature files and step definitions if needed. Let me know if you want the Cucumber integration as well.