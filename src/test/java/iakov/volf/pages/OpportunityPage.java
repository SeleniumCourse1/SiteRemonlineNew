package iakov.volf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Iakov Volf on 2/19/2015.
 */


public class OpportunityPage extends Page {

    public static final String FIND_TEXT_LOK = "//*[@class='b-feature__title h-ta-c']";
    public WebDriverWait wait;

    @FindBy(xpath = FIND_TEXT_LOK)
    WebElement opportunityText;

    @FindBy(xpath = "//*[@class='b-navbar__item b-navbar__item_state_active']")
    WebElement LinkOpportunity;
    

    public OpportunityPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://dev.remonline.ru/features";
       // this.PAGE_TITLE = "Login";
       //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public boolean isOnOpportunityPage () {
        
      return exists(opportunityText);
        
    }

    public void waitForFindTextToLoad (){
         waitForElement(wait, FIND_TEXT_LOK);
        
    }
    public void assertOpportunity() {
        assertEquals("Возможности", opportunityText.getText());
    }
}


