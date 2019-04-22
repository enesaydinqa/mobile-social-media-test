package com.appium.pages.youtube;


import com.appium.pages.snapchat.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

public class MainPage extends PageObject {
    public MainPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(xpath = "//img[@id='screenshot']/parent::div/div/div[20]"),
            @AndroidBy(xpath="//android.widget.ImageView[@content-desc='Ara']")
    })
    public MobileElement searchButton;

    @AndroidFindAll({
            @AndroidBy(id = "com.google.android.youtube:id/search_edit_text")
    })
    public MobileElement searchText;

    @AndroidFindAll({
            @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android." +
                    "widget.LinearLayout/android.widget.FrameLayout/android.widget." +
                    "LinearLayout/android.widget.FrameLayout/android.view.View/android." +
                    "widget.FrameLayout/android.widget.FrameLayout/android.view.View/android." +
                    "view.View/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget." +
                    "ListView/android.widget.LinearLayout[1]/android.widget.TextView")
    })
    public MobileElement firstSearchedRow;

    @AndroidFindAll({
            @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget." +
                    "LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android." +
                    "widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget." +
                    "FrameLayout/android.view.View/android.view.View/android.widget.FrameLayout[2]/android." +
                    "widget.FrameLayout/android.view.View/android.widget.FrameLayout[1]/android.widget.LinearLayout/android." +
                    "widget.RelativeLayout[2]/android.widget.TextView[1]")
    })
    public MobileElement firstVideo;



}
