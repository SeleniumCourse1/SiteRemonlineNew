package iakov.volf;

/**
 * Created by Olga on 1/27/2015.
 */


import iakov.volf.pages.HeaderPage;
import iakov.volf.pages.OpportunityPage;
import iakov.volf.pages.RegisterFirstPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpportunityTest {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public WebDriver driver;
    public WebDriverWait wait;
    RegisterFirstPage registerFirstPage;
    HeaderPage headerPage;
    OpportunityPage opportunityPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        //  wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://dev.remonline.ru/");
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
    }


    @Test
    public void testOpportunitiesRemOnline() throws Exception {
       headerPage.openOportunityPage();

    }





}