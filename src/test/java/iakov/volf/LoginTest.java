package iakov.volf;

/**
 * Created by yura on 1/27/2015.
 */


import iakov.volf.pages.HeaderPage;
import iakov.volf.pages.LoginPage;
import iakov.volf.pages.OrdersPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    LoginPage loginPage;
    OrdersPage ordersPage;
    HeaderPage headerPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        headerPage.openLoginPage();
        ordersPage = PageFactory.initElements(driver, OrdersPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }

    @Test
    public void TestLoginSuccess() {
        try {
            loginPage.login();
            ordersPage.onOrdersPage();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void TestLoginInsuccess() {
        try {
            loginPage.loginWithoutPass();
            Assert.assertTrue(loginPage.isNotLoggedIn());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}