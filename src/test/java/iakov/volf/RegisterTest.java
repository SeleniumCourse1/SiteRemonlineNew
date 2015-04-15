package iakov.volf;


import iakov.volf.pages.HeaderPage;
import iakov.volf.pages.RegisterFirstPage;
import iakov.volf.pages.RegisterSecondPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Iakov
 */

public class RegisterTest extends TestNgTestBase {
    public StringBuffer verificationErrors = new StringBuffer();
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    HeaderPage headerPage;
    RegisterFirstPage registerFirstPage;
    RegisterSecondPage registerSecondPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
        registerSecondPage = PageFactory.initElements(driver, RegisterSecondPage.class);

       // redirected to page???
       
    }
    @Test
    public void RegisterSuccessfulTest() throws Exception {
        try {

            //must clean cookey!!!
            headerPage.loadPage();
            headerPage.openRegistrationFirstPage();

            registerFirstPage.onRegisterFirstPage();
            registerFirstPage.fillFirstRegisterForm("email.com", "Login", "123456");
            registerFirstPage.confirmFirstRegistrationFormButton();
            registerSecondPage.onRegisterSecondPage();
            registerSecondPage.fillSecondRegisterForm("Mary", "Popinse", "SelfEmployed", "London");
            registerSecondPage.clickOnRegisterButton();

            //add next page


        } catch (Exception e) {
            e.printStackTrace();
        }
//        public void registerFirstFormTest() {
//            try {
//                registerFirstPage.
//                assertTrue(isElementPresent(By.xpath("//*[@class=\"js-auth-signin b-navbar__exit h-ml-10\"]")));
//            } catch (Error e) {
//                verificationErrors.append(e.toString());
//            }
//        }
      
       //what's this?
//        driver.findElement(By.xpath("//div[6]/button")).click();
//        try {
//            assertTrue(isElementPresent(By.xpath("//a/span")));
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }
   
    

        //todo add clickbutton method
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

