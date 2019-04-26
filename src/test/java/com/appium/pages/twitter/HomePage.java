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

    @AndroidFindBy(xpath="//android.view.View[@resource-id='com.twitter.android:id/toolbar']//android.widget.ImageButton")
    public MobileElement threeLine;


    //threeline panel
    @AndroidFindBy(xpath="(//android.widget.TextView[@resource-id='com.twitter.android:id/title'])[5]")
    public MobileElement settings;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android." +
            "widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout")
    public MobileElement account;

    @AndroidFindBy(xpath="(//android.widget.ListView[@resource-id='android:id/list']//android.widget.TextView[@resource-id='android:id/title'])[8]")
    public MobileElement exitt;//switch to yapılacak

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.twitter.android:id/country_learn_more']/parent::*")
    public MobileElement twitterDatas;//scroll işlemi için kullanılacak

    @AndroidFindBy(id="android:id/button1")
    public MobileElement yesExit;

    @AndroidFindBy(xpath="(//android.widget.TextView[@resource-id='com.twitter.android:id/title'])[1]")
    public MobileElement profile;

    @AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView//android.view.View[@resource-id='com.twitter.android:id/row'])[1]")
    public MobileElement lastTweet;//burada kaldım

    @AndroidFindBy(id="com.twitter.android:id/root_coordinator_layout")
    public MobileElement dnm;
}
