package com.appium.pages.instagram;

import com.appium.pages.snapchat.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FooterPage extends PageObject
{
    public FooterPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Camera']")
    public MobileElement cameraButton;

}
