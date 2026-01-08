public class AutomationTest {
    public void openWebsite() {
        // Navigate to the specified URL
        driver.get("https://kairos--test.azurewebsites.net/solutionAnalysisInfo/solutionanalysis?organization=Capgemini-Sandbox&portfolio=Performance%20Testing&portfolioId=5124");
        // Validate the page title or any other element to ensure the page has loaded
        String expectedTitle = "Solution Analysis Info";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
}