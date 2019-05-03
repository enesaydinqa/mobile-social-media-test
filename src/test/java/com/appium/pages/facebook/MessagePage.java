package com.appium.pages.facebook;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MessagePage extends PageObject {
    public MessagePage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.EditText\n")
    public MobileElement messageText;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Send']")
    public MobileElement sendMessageButton;
}
