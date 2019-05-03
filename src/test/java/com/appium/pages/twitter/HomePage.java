package com.appium.pages.twitter;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject
{
    public HomePage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(id = "com.twitter.android:id/composer_write")
    public MobileElement tweetButton;

    @AndroidFindBy(id = "com.twitter.android:id/tweet_text")
    public MobileElement tweetText;

    @AndroidFindBy(id = "com.twitter.android:id/button_tweet")
    public MobileElement buttonTweetButton;

    @AndroidFindBy(accessibility = "Show navigation drawer")
    public MobileElement threeLineButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings and privacy']")
    public MobileElement settingsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account']")
    public MobileElement accountTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log out']")
    public MobileElement logoutTitle;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.twitter.android:id/title'])[1]")
    public MobileElement profile;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.view.View[@resource-id='com.twitter.android:id/row'])[1]")
    public MobileElement lastTweet;
}
