package com.swiggy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SwiggyLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void loginToSwiggy() {
        driver.get("https://www.swiggy.com");
        WebElement loginButton = driver.findElement(By.id("loginButtonId"));
        loginButton.click();
        WebElement emailField = driver.findElement(By.id("emailFieldId"));
        emailField.sendKeys("test@example.com");
        WebElement passwordField = driver.findElement(By.id("passwordFieldId"));
        passwordField.sendKeys("password123");
        WebElement submitButton = driver.findElement(By.id("submitButtonId"));
        submitButton.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
