package pages.project02;

import logger.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().getPropertyValue("base.url");

    @FindBy(xpath = "//*[contains(text(),'Front-End')]")
    WebElement homeFrontEndText;

    public void open(){
        MyLogger.infoExtentStep("Opening home page");
        openBrowser(HOME_URL);
    }

    public void verifyHomeFrontEndPresent() {
        assertElementIsPresent(homeFrontEndText);
    }
}