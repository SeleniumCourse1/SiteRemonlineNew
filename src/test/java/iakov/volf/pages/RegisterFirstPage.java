package iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lena on 26/02/2015.
 */
public class RegisterFirstPage extends Page {

    @FindBy(xpath = "//h2[@class='h-ta-c']")
    WebElement firstRegPageHeader;
    @FindBy(id = "l-auth-email")
    WebElement email;
    @FindBy(id = "l-auth-login")
    WebElement login;
    @FindBy(id = "l-auth-pass")
    WebElement password; 




    public RegisterFirstPage(WebDriver driver) {

        super(driver);
        // this.PAGE_URL = "";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
    }
    

      
    public void clickOnRegisterButton() throws InterruptedException {
        driver.findElement(By.xpath("//li[4]//span[@class='js-auth-signup b-navbar__entrance h-ml-15']")).click();
    }
    public void onRegisterFirstPage(){
        verifyText("Регистрация компании", firstRegPageHeader);
        }

   
   

    //____________________________________________________________________________


    public void fillFirstRegisterForm(String email, String login, String password) {
        driver.findElement(By.id("l-auth-email")).clear();
        driver.findElement(By.id("l-auth-email")).sendKeys(email);

        driver.findElement(By.id("l-auth-login")).clear();
        driver.findElement(By.id("l-auth-login")).sendKeys(login);

        driver.findElement(By.id("l-auth-pass")).clear();
        driver.findElement(By.id("l-auth-pass")).sendKeys(password);
    }

    public void confirmFirstRegistrationFormButton() {
        driver.findElement(By.xpath("//button[@class='b-button_type_cta b-button_color_green js-submit']")).click();
    }
    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
