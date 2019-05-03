package com.appium.pages.facebook;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public HomePage(AppiumDriver driver) {super(driver);}

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public MobileElement locationPermission;

    public By locationPermissionBy = By.id("com.android.packageinstaller:id/permission_deny_button");

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Tab 4 of 4\"]\n")
    public MobileElement selectBar;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Photo']")
    public MobileElement photoButton;

    public By photoPermission = By.id("com.android.packageinstaller:id/permission_allow_button");

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
    public MobileElement shareTextClick;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='Comment Button'])[1]")
    public MobileElement commentButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText")
    public MobileElement commentWriteText;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Send']")
    public MobileElement commentSendMessageButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='Like button. Double tap and hold to react.'])[1]")
    public MobileElement likeButton;

    public By likeButtonBy = By.id("(//android.widget.TextView[@content-desc='Like button. Double tap and hold to react.'])[1]");

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Like button, pressed. Double tap and hold to change reaction.']")
    public MobileElement dontLikeButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='News Feed, Tab 1 of 4']")
    public MobileElement refreshButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    public MobileElement homeLayout;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Messaging']")
    public MobileElement messageButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    public MobileElement searchButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText")
    public MobileElement searchText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ahmet yılmaz']")
    public MobileElement searchSelectUser;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Send message']")
    public MobileElement searchUserMessageButton;
}
