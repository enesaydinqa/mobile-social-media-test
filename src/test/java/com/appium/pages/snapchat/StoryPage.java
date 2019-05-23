package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class StoryPage extends PageObject
{
    public StoryPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(id = "com.snapchat.android:id/camera_capture_button")
    public MobileElement cameraCaptureButton;

    @AndroidFindBy(id = "com.snapchat.android:id/send_btn")
    public MobileElement sendButton;

    @AndroidFindBy(id = "com.snapchat.android:id/send_to_bottom_panel_send_button")
    public MobileElement send;

    @AndroidFindAll({
            @AndroidBy(className = "android.widget.TextView")})
    public List<MobileElement> addStory;

    @AndroidFindBy(id = "com.snapchat.android:id/button_text")
    public MobileElement addToAlert;

    @AndroidFindBy(id = "com.snapchat.android:id/send_to_search_text")
    public MobileElement searchFriends;

    @AndroidFindBy(id = "com.snapchat.android:id/hova_nav_feed_icon")
    public MobileElement friends;

    @AndroidFindAll({
            @AndroidBy(id = "com.snapchat.android:id/name")
    })
    public MobileElement myStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow']")
    public MobileElement alert;
}
