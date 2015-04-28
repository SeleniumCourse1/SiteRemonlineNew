package iakov.volf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Khmelnitsky Miroslav on 4/28/2015.
 */


public class BlogPage extends Page {


    @FindBy(xpath = "//a[@class='h-d-ib h-mt-15']")
    WebElement linkContinueReed;


    public BlogPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://dev.remonline.ru/blog";
       // this.PAGE_TITLE = "Login";
       //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public boolean  isOnBlogPage () {
        
       return exists(linkContinueReed);
        
    }

    public void assertOpportunity() {
        assertEquals("Продолжить чтение →", linkContinueReed.getText());
    }
}


