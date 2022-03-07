package pages.project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HomePO extends BasePage {

    public static final String HOME_URL = "http://automationpractice.com";

    @FindBy(xpath = "//a[text()='Women']")
    WebElement womenSection;

    public HomePO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void open(){
        openBrowser(HOME_URL);
    }

    public void goToSectionOne() {
        womenSection.click();
    }
}