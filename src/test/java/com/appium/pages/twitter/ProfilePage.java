package com.appium.pages.twitter;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends PageObject {

    public ProfilePage(AppiumDriver driver){super(driver);}

    @AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView[@resource-id='android:id/list']//android.view.View[@content-desc])[2]")
    public MobileElement lastTweet;

    @AndroidFindBy(xpath="//android.view.View[@resource-id='com.twitter.android:id/toolbar']/android.widget.ImageButton")
    public MobileElement back;
}
