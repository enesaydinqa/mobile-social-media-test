package com.appium.pages.instagram;

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

    @AndroidFindBy(id = "com.instagram.android:id/log_in_button")
    public MobileElement logIn;

    @AndroidFindBy(id = "com.instagram.android:id/login_username")
    public MobileElement usernameInput;

    @AndroidFindBy(id = "com.instagram.android:id/password")
    public MobileElement passwordInput;

    @AndroidFindBy(id = "com.instagram.android:id/button_text")
    public MobileElement loginButton;

    @AndroidFindBy(id = "com.instagram.android:id/button_positive")
    public MobileElement buttonPositive;

}
