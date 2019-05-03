package com.appium.pages.facebook;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageObject
{
    public LoginPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Username']")
    public MobileElement userName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Password']")
    public MobileElement password;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Login click']")
    public MobileElement loginButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")
    public MobileElement selectUser;

}
