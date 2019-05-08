package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ProfilePage extends PageObject {
    public ProfilePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(className = "android.widget.TextView")})//4
    public List<MobileElement> findFriends;

    @AndroidFindBy(id = "com.snapchat.android:id/loading_spinner_button_text")
    public MobileElement addFriendsButton;

    @AndroidFindBy(id = "com.snapchat.android:id/search_text_view")
    public MobileElement searchButton;

    @AndroidFindBy(id = "com.snapchat.android:id/hova_header_search_icon")
    public MobileElement searchFriends;
    @AndroidFindBy(id = "com.snapchat.android:id/neon_header_title")
    public MobileElement searchFriendsText;

    @AndroidFindBy(id = "com.snapchat.android:id/item")
    public MobileElement firstFriends;




}
