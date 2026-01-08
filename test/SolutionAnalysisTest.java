import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionAnalysisTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void openWebsiteAndClickDocuments() {
        // Open the website
        driver.get("https://kairos--test.azurewebsites.net/solutionAnalysisInfo/solutionanalysis;organization=Capgemini-Sandbox;portfolio=Performance%20Testing;portfolioId=5124");
        
        // Click on Documents
        WebElement documentsLink = driver.findElement(By.xpath("//span[contains(text(), 'Documents')]");
        documentsLink.click();
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}