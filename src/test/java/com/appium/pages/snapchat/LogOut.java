package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogOut extends PageObject {
    public LogOut(AppiumDriver driver) {

        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.snapchat.android:id/neon_header_avatar_container"),
            @AndroidBy(id = "com.snapchat.android:id/avatar_silhouette_3")
    } )
    public MobileElement userProfileButton;

    @AndroidFindAll({
            @AndroidBy(id = "com.snapchat.android:id/hova_header_search_icon")
            //@AndroidBy(id = "com.snapchat.android:id/avatar_silhouette_3")
    } )
    public MobileElement searchButton;

    @AndroidFindBy(id = "com.snapchat.android:id/profile_header_menu_button")
    public MobileElement settingButton;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[9]")
    public MobileElement logoutButton;

    @AndroidFindBy(id = "com.snapchat.android:id/avatar_story")
    public MobileElement storyButton;
}
