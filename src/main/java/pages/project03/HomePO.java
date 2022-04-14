package pages.project03;

import logger.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().getPropertyValue("base.url");

    public void open(){
        MyLogger.infoExtentStep("Opening home page");
        openBrowser(HOME_URL);
    }
}