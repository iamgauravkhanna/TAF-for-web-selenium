package pages.project03;

import logger.TestLogger;
import pages.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().getPropertyValue("base.url");

    public void open(){
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(HOME_URL);
    }
}