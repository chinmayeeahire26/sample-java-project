package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MicrosoftLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToMicrosoft() {
        driver.get("https://login.microsoftonline.com/");

        WebElement emailField = driver.findElement(By.id("i0116"));
        emailField.sendKeys("your-email@example.com");

        WebElement nextButton = driver.findElement(By.id("idSIButton9"));
        nextButton.click();

        WebElement passwordField = driver.findElement(By.name("passwd"));
        passwordField.sendKeys("your-password");

        WebElement signInButton = driver.findElement(By.id("idSIButton9"));
        signInButton.click();

        // Add a wait or assertion to verify successful login
        WebElement profileIcon = driver.findElement(By.id("profile-icon-id"));
        Assert.assertTrue(profileIcon.isDisplayed(), "Login was not successful");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
