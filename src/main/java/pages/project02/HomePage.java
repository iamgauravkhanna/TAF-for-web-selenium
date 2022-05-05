package pages.project02;

import logger.TestLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.ConfigLoader;

public class HomePage extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().get("base.url");

    @FindBy(xpath = "//*[contains(text(),'Front-End')]")
    WebElement homeFrontEndText;

    public void open(){
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(HOME_URL);
    }

    public void verifyHomeFrontEndPresent() {
        assertElementIsPresent(homeFrontEndText);
    }
}