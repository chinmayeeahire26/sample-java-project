import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DttLoginAutomation {
    public void loginToDtt() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Open the login page
            driver.get("https://kairos-capgemini.azurewebsites.net/login");

            // Click on Your Image
            WebElement yourImage = driver.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[1]/div[2]/div[1]/img[1]"));
            yourImage.click();

            // Click on login button
            WebElement loginButton = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/app-header[1]/div[1]/div[1]/nav[1]/a[4]/img[1]"));
            loginButton.click();

            // Enter Username
            WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
            usernameField.sendKeys("shaik-raghiba.sulthana@capgemini-test.com");

            // Enter Password
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
            passwordField.sendKeys("Test@1234");

            // Click on Description of the image
            WebElement descriptionImage = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/app-login-register-modal[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]/span[2]/img[1]"));
            descriptionImage.click();

            // Click on Select Portfolio
            WebElement selectPortfolio = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[2]/div[1]"));
            selectPortfolio.click();

            // Click on option
            WebElement option = driver.findElement(By.xpath("//mat-option[@id='mat-option-4']"));
            option.click();

            // Click on combobox
            WebElement comboBox = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/mat-form-field[1]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]"));
            comboBox.click();

            // Click on Requirements Analysis
            WebElement requirementsAnalysis = driver.findElement(By.xpath("//span[contains(text(), 'Requirements Analysis')]");
            requirementsAnalysis.click();

            // Click on tab
            WebElement tab = driver.findElement(By.xpath("//a[@id='mat-tab-link-6']"));
            tab.click();

            // Click on Logout
            WebElement logout = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]");
            logout.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}