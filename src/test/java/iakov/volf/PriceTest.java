package iakov.volf;

import iakov.volf.pages.PricePage;
import iakov.volf.pages.RegisterFirstPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by Lena on 22/01/2015.
 */
public class PriceTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    PricePage pricePage;
    RegisterFirstPage registerFirstPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
      //  wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://dev.remonline.ru/");
        pricePage = PageFactory.initElements(driver, PricePage.class);
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
    }

    @Test
    public void TestPricePageElements() {
        try {
            pricePage.testPrice();
            registerFirstPage.onRegisterPage();


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

