package com.appium.pages.twitter;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject {
    public HomePage(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id="com.twitter.android:id/composer_write")
    public MobileElement tweet;
    @AndroidFindBy(id="com.twitter.android:id/self_thread_content")
    public MobileElement messageText;
    @AndroidFindBy(id="com.twitter.android:id/button_tweet")
    public MobileElement sendMessage;
}
