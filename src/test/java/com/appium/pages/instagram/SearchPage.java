package com.appium.pages.instagram;

import com.appium.pages.snapchat.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends PageObject {

    public SearchPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(id ="com.instagram.android:id/action_bar_search_edit_text")
    public MobileElement searchText;

    @AndroidFindBy(id ="com.instagram.android:id/row_search_avatar_in_ring")
    public MobileElement firstSearchedOne;

    @AndroidFindBy(id ="com.instagram.android:id/row_profile_header_direct_message")
    public MobileElement sendMessageButton;
}
