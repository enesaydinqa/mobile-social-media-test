package com.appium.pages.instagram;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class PostSendPage extends PageObject
{
    public PostSendPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='GALLERY']")
    public MobileElement galleryTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Next']")
    public MobileElement nextTitle;

    public By pendingContainer = By.id("com.instagram.android:id/row_pending_container");
}
