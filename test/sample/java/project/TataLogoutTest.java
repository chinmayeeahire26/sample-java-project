import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.cucumber.java.en.When;

public class TataLogoutTest {

 private WebDriver driver;

 @Test
 public void logoutFromTata() {
 // Navigate to the Tata application
 driver.get("https://www.tata.com");

 // Click on the logout button
 driver.findElement(By.id("logoutButton")).click();

 // Verify logout success
 String currentUrl = driver.getCurrentUrl();
 assert currentUrl.equals("https://www.tata.com/login");
 }

 @When("user logs out from Tata")
 public void userLogsOutFromTata() {
 logoutFromTata();
 }
}