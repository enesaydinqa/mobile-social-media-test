package com.appium.pages.instagram;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

public class HomePage extends PageObject
{
    public HomePage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.ImageView[@content-desc='Message']"),
            @AndroidBy(xpath = "//android.widget.ImageView[@content-desc='1 unread message']")
    })
    public MobileElement messageButton;

}
