package pages.project03;

import logger.TestLogger;
import pages.base.BasePage;
import utils.ConfigLoader;

public class HomePage extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().get("base.url");

    public void open(){
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(HOME_URL);
    }
}