package pages.project01;

import logger.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().getPropertyValue("base.url");

    @FindBy(xpath = "//a[text()='Women']")
    WebElement womenSection;

    public HomePO(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void open(){
        MyLogger.infoExtentStep("Opening home page");
        openBrowser(HOME_URL);
    }

    public void goToSectionOne() {
        womenSection.click();
    }
}