import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenWebsiteTest {

    @Test
    public void openWebsite() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kairos--test.azurewebsites.net/solutionAnalysisInfo/solutionanalysis;organization=Capgemini-Sandbox;portfolio=Performance%20Testing;portfolioId=5124");
        // Additional test logic here
        driver.quit();
    }
}