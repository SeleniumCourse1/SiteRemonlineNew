package iakov.volf;
/**
 * Created by Slava on 1/27/2015.
 */

import iakov.volf.pages.HeaderPage;
import iakov.volf.pages.OrdersPage;
import iakov.volf.pages.WriteUsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

public class WriteUsTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

   WriteUsPage writeUsPage;
    public WebDriverWait wait;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        writeUsPage = PageFactory.initElements(driver, WriteUsPage.class);

    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }
    @Test
    public void testWriteUs1() throws Exception {
        writeUsPage.openWriteToUsPage();
        writeUsPage.fillTheFields("Slava", "miroxa1979@gmail.com", "Test" );
        writeUsPage.clickToSummit();
        }




    private void clickOnPage() {
        driver.findElement(By.cssSelector("div.reveal-modal-bg")).click();
    }

    private void submitText() {
        driver.findElement(By.xpath("//div[4]/button")).click();
    }

    private void fillTheFields(String name, String mail, String text) {
        driver.findElement(By.id("l-auth-name")).click();
        driver.findElement(By.id("l-auth-name")).clear();
        driver.findElement(By.id("l-auth-name")).sendKeys(name);
        driver.findElement(By.id("l-auth-email")).clear();
        driver.findElement(By.id("l-auth-email")).sendKeys(mail);
        driver.findElement(By.id("l-auth-message")).clear();
        driver.findElement(By.id("l-auth-message")).sendKeys(text);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
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
