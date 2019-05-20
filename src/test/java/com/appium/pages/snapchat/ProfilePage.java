package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends PageObject {
    public ProfilePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.snapchat.android:id/hova_header_search_icon")
    public MobileElement searchFriends;
    @AndroidFindBy(id = "com.snapchat.android:id/neon_header_title")
    public MobileElement searchFriendsText;

    @AndroidFindBy(id = "com.snapchat.android:id/item")
    public MobileElement firstFriends;




}
