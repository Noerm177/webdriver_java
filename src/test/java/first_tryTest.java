import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class first_tryTest {

    @Test
    public void site_header_is_on_home_page() {
        WebDriver browser;
        //Firefox's geckodriver *requires* you to specify its location.
        browser = new FirefoxDriver();
        browser.get("http://saucelabs.com");
        WebElement header = browser.findElement(By.id("headerMainNav"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

}