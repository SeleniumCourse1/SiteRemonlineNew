package iakov.volf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iakov Volf on 2/19/2015.
 */
public class HeaderPage extends Page {


    @FindBy(xpath = "//*[@class='b-navbar__logo pull-left']")
    WebElement goToHomePage;
    @FindBy(xpath = "//*[@class='b-navbar__item'][@href='/pricing']")
    WebElement goToPriceButton;
    @FindBy(xpath = "//*[@class='b-navbar__item b-navbar__item_state_active'][@href='/features']")
    WebElement goToOpportunity;
    @FindBy(linkText = "Блог")
    WebElement goToBlog;
    @FindBy(linkText = "Вход")
    WebElement goToLoginButton;
    @FindBy(xpath = "//li[4]//span[@class='js-auth-signup b-navbar__entrance h-ml-15']")
    WebElement goToRegistrationButton;

    public HeaderPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://dev.remonline.ru/";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void openLoginPage() {
       // loadPage();
        clickElement(goToLoginButton);
        LoginPage loginPage;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    public void openBlogPage() {
        // loadPage();
        clickElement(goToBlog);
        BlogPage blogPage;
        blogPage = PageFactory.initElements(driver, BlogPage.class);
    }
    public void openRegistrationFirstPage() {
        //loadPage();
        clickElement(goToRegistrationButton);
        RegisterFirstPage registerFirstPage;
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
    }

    public void openPricePage() {
        //loadPage();
        clickElement(goToPriceButton);
        PricePage pricePage;
        pricePage = PageFactory.initElements(driver, PricePage.class);
    }

    public void openHomePage(){
        clickElement(goToHomePage);
        HomePage homePage;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public void openOportunityPage() {
        loadPage();
        clickElement(goToOpportunity);
        OpportunityPage opportunityPage;
        opportunityPage = PageFactory.initElements(driver, OpportunityPage.class);
    }
}
