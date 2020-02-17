package internetFrame.pages;

import internetFrame.utility.ServicesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class LoginPage extends ServicesMethods {

    private final static String HEADING = "Login Page";
    public static final String MSG_SUCCESS = "You logged into a secure area!";
    private static final String MSG_ERROR = "Your username is invalid!";
    private static final String MSG_LOGOUT = "You logged out of the secure area!";
    private String xpathHeading = "//h2";

    //CSS
    private String cssUsername = "input[name='username']";
    private String cssPassword = "input[name='password']";
    private String cssLoginBtn = "button[type='submit']";

    private String xpathLogoutBtn = "//a[contains(@class,'button')]";
    private String xpathMsg = "//div[@id='flash']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLPHeader() {
        waitElement(xpathHeading);
        WebElement headerElm = getWebE(By::xpath, xpathHeading);
        String actualHead = headerElm.getText();
        assertEquals(actualHead, HEADING,
                "Actual "+ actualHead + "should be same as "+ MSG_SUCCESS + ".");
    }

}
