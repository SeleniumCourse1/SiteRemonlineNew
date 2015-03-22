package iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lena on 25/02/2015.
 */
public class WriteUsPage extends Page {
    @FindBy(xpath = "//*[@class=\"js-auth-feedback h-dashed-link\"]" ) WebElement goToWriteUsButton ;
    @FindBy (id = "l-auth-name") WebElement nameField;
    @FindBy (id = "l-auth-email") WebElement mailField;
    @FindBy (id = "l-auth-message") WebElement textField;
    @FindBy (xpath = "//button[@class='b-button_type_cta b-button_color_green js-submit']") WebElement  buttonSubmit;

    public WriteUsPage(WebDriver driver){

        super(driver);
        this.PAGE_URL = "dev.remonline.ru";

        PageFactory.initElements(driver, this);
    }

// Elements on the page
public void openWriteToUsPage() {
    driver.get(PAGE_URL);
    clickElement(goToWriteUsButton);
}

    public void fillTheFields(String name, String email, String text) {
        nameField.sendKeys(name);
        mailField.sendKeys(email);
        textField.sendKeys(text);

    }
    public void clickToSummit() {
        clickElement(buttonSubmit);
    }


    WebDriverWait wait = new WebDriverWait(driver, 5); // wait for a maximum of 5 seconds
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.b-modal > h2.h-ta-c")));

}
