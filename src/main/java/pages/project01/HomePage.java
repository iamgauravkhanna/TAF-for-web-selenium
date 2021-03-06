package pages.project01;

import constants.TestConstants;
import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import config.ConfigLoader;
import screenshot.ScreenShotUtil;

public class HomePage extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().get(TestConstants.BASE_URL);

    @FindBy(xpath = "//a[text()='Women']")
    WebElement womenSection;

    public void open(){
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(HOME_URL);
        pause();
    }

    public void goToSectionOne() {
        //womenSection.click();
        findElement(By.xpath("//a[text()='Women']")).click();
        ScreenShotUtil.takeScreenShot();
    }
}