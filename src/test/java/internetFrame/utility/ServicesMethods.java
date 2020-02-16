package internetFrame.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;
import static org.apache.log4j.Logger.getLogger;

/** set up for the driver methods **/
public class ServicesMethods {

    private static Logger logger = getLogger(ServicesMethods.class.getName());
    protected WebDriver driver;

    public ServicesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitElement(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /** interfaces for any type of locator**/
    protected void sendText(Function<String, By> locate, String locator, String text) {
        driver.findElement(locate.apply(locator)).sendKeys(text);
    }

    protected void click(Function<String, By> locate, String locator) {
        driver.findElement(locate.apply(locator)).click();
    }

    protected WebElement getWebE(Function<String, By> locate, String locator) {
       return driver.findElement(locate.apply(locator));
    }

    protected void waitForElementVisible(Function<String, By> locate,String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locate.apply(locator)));
    }

}
