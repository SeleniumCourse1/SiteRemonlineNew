package iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.fail;

/**
 * Created by Lena on 03/03/2015.
 */
public class RegisterSecondPage extends Page {

    @FindBy(id = "l-auth-name") //change id for secondRegPageHeader;
    WebElement secondRegPageHeader;
    @FindBy(id = "l-auth-name")
    WebElement firstName;
    @FindBy(id = "l-auth-lname")
    WebElement lastName;
    @FindBy(id = "l-auth-company")
    WebElement companyName;
    @FindBy(id = "js-auth-country")
    WebElement coutry;
    @FindBy(id = "l-auth-city")
    WebElement city;
    @FindBy(id = "l-auth-phone")
    WebElement phone;
    @FindBy(xpath = "//div[5]/button")
    WebElement submitRegisterButton;

    public RegisterSecondPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this); 
    }

    public void onRegisterSecondPage(){
        verifyText("Регистрация компании", secondRegPageHeader);
    }

   public void fillSecondRegisterForm(String firstName, String lastName, String companyName, String city) throws InterruptedException {
        //firstName
        driver.findElement(By.id("l-auth-name")).click();
        driver.findElement(By.id("l-auth-name")).clear();
        driver.findElement(By.id("l-auth-name")).sendKeys(firstName);
        //lastName
        driver.findElement(By.id("l-auth-lname")).click();
        driver.findElement(By.id("l-auth-lname")).clear();
        driver.findElement(By.id("l-auth-lname")).sendKeys(lastName);
        //companyName
        driver.findElement(By.id("l-auth-company")).click();
        driver.findElement(By.id("l-auth-company")).clear();
        driver.findElement(By.id("l-auth-company")).sendKeys(companyName);
        //selectCountry
        driver.findElement(By.id("js-auth-country")).click();
        //driver.findElement(By.xpath("//li[@class='clearfix b-dropdown__item'][index]"));
        selectCountryByIndex(3);


        //city
        driver.findElement(By.id("l-auth-city")).click();
        driver.findElement(By.id("l-auth-city")).clear();
        driver.findElement(By.id("l-auth-city")).sendKeys(city);

        //telephone
        driver.findElement(By.id("l-auth-phone")).click();
    }

    private void selectCountryByIndex(int index) {
        driver.findElement(By.xpath("//li[@class='clearfix b-dropdown__item']["+(index + 1) + " ]")).click();

    }


    public void clickOnRegisterButton() throws InterruptedException {
        driver.findElement(By.xpath("//li[4]//span[@class='js-auth-signup b-navbar__entrance h-ml-15']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//body/div[4]"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
    }

    }


