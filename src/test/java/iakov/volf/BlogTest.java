package iakov.volf;

/**
 * Created by Miroslav 5.04.15
 */


import iakov.volf.pages.BlogPage;
import iakov.volf.pages.HeaderPage;
import iakov.volf.pages.OpportunityPage;
import iakov.volf.pages.RegisterFirstPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BlogTest {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public WebDriver driver;
    public WebDriverWait wait;
    RegisterFirstPage registerFirstPage;
    HeaderPage headerPage;
    BlogPage blogPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        //  wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("http://dev.remonline.ru/");
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
        blogPage = PageFactory.initElements(driver, BlogPage.class);
    }


    @Test
    public void testBlogRemonline() throws Exception {
        blogPage.loadPage();
        Assert.assertTrue (blogPage.isOnBlogPage());
    }



    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }

}