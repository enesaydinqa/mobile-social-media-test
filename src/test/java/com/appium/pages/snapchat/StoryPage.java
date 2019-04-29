package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StoryPage extends PageObject
{
    public StoryPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(id = "com.snapchat.android:id/camera_capture_button")
    public MobileElement cameraCaptureButton;

    @AndroidFindBy(id = "com.snapchat.android:id/lenses_camera_button_view")
    public MobileElement lensButton;

    @AndroidFindBy(id = "com.snapchat.android:id/send_btn")
    public MobileElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Story']")
    public MobileElement myStoryTitle;

    @AndroidFindBy(id = "com.snapchat.android:id/send_to_bottom_panel_send_button")
    public MobileElement send;

    @AndroidFindBy(id = "com.snapchat.android:id/status_bar_secondary_text")
    public MobileElement sharedNotification;

    @AndroidFindBy(id = "com.snapchat.android:id/avatar_story")
    public MobileElement avatarImage;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.snapchat.android:id/item_image'])[4]")
    public MobileElement firstFilterButton;


}
