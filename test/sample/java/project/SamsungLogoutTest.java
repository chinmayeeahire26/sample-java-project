import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.cucumber.java.en.When;

public class SamsungLogoutTest {

    private WebDriver driver;

    @Test
    @When("^user logs out from the Samsung application$")import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.cucumber.java.en.When;

public class SamsungLogoutTest {

    private WebDriver driver;

    @Test
    @When("^user logs out from the Samsung application$")
    public void logoutFromSamsungApp() {
        // Navigate to the logout page
        driver.findElement(By.id("logoutButton")).click();
        // Verify logout success
        boolean isLoggedOut = driver.findElement(By.id("loginPage")).isDisplayed();
        assert isLoggedOut : "Logout failed";
    }

}

}