package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class StoryPage extends PageObject {
    public StoryPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.snapchat.android:id/camera_capture_button")
    public MobileElement cameraCaptureButton;

    @AndroidFindBy(id = "com.snapchat.android:id/lenses_camera_button_view")
    public MobileElement lensButton;

    @AndroidFindBy(id = "com.snapchat.android:id/send_btn")
    public MobileElement sendButton;

    @AndroidFindAll({
            @AndroidBy(className = "android.widget.TextView")})
    public List<MobileElement> myStoryTitle;//3

    @AndroidFindBy(id = "com.snapchat.android:id/send_to_bottom_panel_send_button")
    public MobileElement send;

    @AndroidFindAll({
           // @AndroidBy(xpath = "(//android.view.View[@resource-id='com.snapchat.android:id/item'])[2]//android.widget.TextView"),
            @AndroidBy(className = "android.widget.TextView")})
    public List<MobileElement> addStory;

    @AndroidFindBy(id = "com.snapchat.android:id/button_text")
    public MobileElement addToAlert;

    @AndroidFindBy(id = "com.snapchat.android:id/neon_header_title")
    public MobileElement addImageToStorySuccessMessage;

    @AndroidFindBy(id = "com.snapchat.android:id/neon_header_avatar_container")
    public MobileElement avatarImage;

    @AndroidFindBy(id = "com.snapchat.android:id/send_to_search_text")
    public MobileElement searchFriends;

    @AndroidFindBy(id = "com.snapchat.android:id/name")
    public MobileElement firstFriendsRow;


    @AndroidFindAll({
            @AndroidBy(className = "android.widget.TextView")})
    public List<MobileElement> sendStory;

    @AndroidFindBy(id = "com.snapchat.android:id/hova_nav_feed_icon")
    public MobileElement friends;
}
