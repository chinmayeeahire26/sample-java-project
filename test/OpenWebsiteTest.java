import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenWebsiteTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void openWebsite() {
        driver.get("https://kairos--test.azurewebsites.net/solutionAnalysisInfo/solutionanalysis;organization=Capgemini-Sandbox;portfolio=Performance%20Testing;portfolioId=5124");
        // Add assertions here to verify the page opened correctly
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}