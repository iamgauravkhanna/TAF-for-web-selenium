package pages.project01;

import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().get("base.url");

    @FindBy(xpath = "//a[text()='Women']")
    WebElement womenSection;

    public void open(){
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(HOME_URL);
    }

    public void goToSectionOne() {
        //womenSection.click();
        findElement(By.xpath("//a[text()='Women']")).click();
    }
}