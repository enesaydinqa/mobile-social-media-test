package com.appium.pages.youtube;

import com.appium.pages.snapchat.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

public class FooterPage extends PageObject {
    public FooterPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.google.android.youtube:id/channel_avatar")
    })
    public MobileElement mainPageButton;
}
