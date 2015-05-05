package iakov.volf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Iakov Volf on 2/19/2015.
 */
public class LoginPage extends Page {


    @FindBy(id = "l-auth-login") WebElement loginUsernameField;
    @FindBy(id = "l-auth-pass") WebElement loginPasswordField;
    @FindBy(xpath = "//div[3]/button") WebElement loginButton;
    @FindBy(xpath = "//span[@class='js-auth-signin b-navbar__exit h-ml-10']") WebElement goToLoginButton;

    public LoginPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://dev.remonline.ru";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public void fillLoginfields (String userName, String pass) {
        setElementText(loginUsernameField, userName);
        setElementText(loginPasswordField, pass);
    }

    public void login() throws Exception {

        waitUntilElementIsLoaded(loginButton);
        fillLoginfields("Mary", "123456");
        clickToLogin();
    }

    public void loginWithoutPass() throws Exception {
        waitUntilElementIsLoaded(loginButton);
        fillLoginfields("Mary", "");
        clickToLogin();
    }

    public void clickToLogin() {
        clickElement(loginButton);
    }

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }

    public boolean exists(WebElement element) {
        return super.exists(element);
    }


    public boolean isLoggedIn(WebElement element) {
        return super.exists(element);
    }

    public boolean isNotLoggedIn() {
        return verifyElementIsPresent(loginButton);
    }

    public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
        super.waitUntilElementIsLoaded(element);
    }

    public void waitForElement(WebDriverWait wait, String element) {
        super.waitForElement(wait, element);
    }
}
