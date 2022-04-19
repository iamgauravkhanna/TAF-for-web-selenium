package pages.project01;

import logger.TestLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().getPropertyValue("base.url");

    @FindBy(xpath = "//a[text()='Women']")
    WebElement womenSection;

    public void open(){
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(HOME_URL);
    }

    public void goToSectionOne() {
        womenSection.click();
    }
}