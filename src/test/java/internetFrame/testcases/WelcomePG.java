package internetFrame.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import internetFrame.utility.ServicesMethods;
import static org.testng.Assert.assertEquals;

public class WelcomePG {

    final static String TITLE = "The Internet";
    final static String HEADING = "Welcome to the-internet";
    String xpathHeading = "//h1";
    String xpathLink = "//ul/li/a[text()='**link**']";
    WebDriver driver;
    ServicesMethods SM = new ServicesMethods(driver);

    public WelcomePG(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyWP() {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, TITLE,
                "Actual title "+ actualTitle + "should be same as "+ TITLE);
    }

    public void verifyWPHead() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHead = headerEle.getText();
        assertEquals(actualHead, HEADING,
                "Actual heading "+ actualHead + "Should be same as" + HEADING);
    }

    public Object clickOnLink(String link) {
        xpathLink = xpathLink.replace("**link**", link);
        driver.findElement(By.xpath(xpathLink)).click();
        return this;
    }


}
