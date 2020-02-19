package internetFrame.pages;

import internetFrame.utility.ServicesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.EmptyStackException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    public String getMsg() {
        try {
            waitForElementVisible(By::cssSelector, xpathMsg);
            return getWebE(By::cssSelector, xpathMsg).getText().trim();

        } catch (Exception e) {
            return "Not found MSG" + e;
        }
    }

    public void loginAction(String username, String password) {
        sendText(By::cssSelector, cssUsername, username);
        sendText(By::cssSelector, cssPassword, password);
        click(By::cssSelector, cssLoginBtn);
    }

    public void verifyLoginCorrect(String username, String password) {
        loginAction(username, password);
        assertTrue(getMsg().contains(MSG_SUCCESS),
                "Actual "+ getMsg()+ "should be same as "+ MSG_SUCCESS);
    }

    public void verifyLoginIncorrect(String username, String password) {
        loginAction(username, password);
        assertTrue(getMsg().contains(MSG_ERROR),
                "Actual "+ getMsg()+ "should be same as "+ MSG_ERROR);
    }

}
