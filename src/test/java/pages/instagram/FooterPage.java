package pages.instagram;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.snapchat.PageObject;

public class FooterPage extends PageObject
{
    public FooterPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Camera']")
    public MobileElement cameraButton;

}
