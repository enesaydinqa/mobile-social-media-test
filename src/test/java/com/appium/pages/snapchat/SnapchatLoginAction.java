package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SnapchatLoginAction extends PageObject {
    public SnapchatLoginAction (AppiumDriver driver) {

        super(driver);
    }
    @AndroidFindBy(id="com.snapchat.android:id/login_and_signup_page_fragment_login_button")
    public MobileElement loginButton;

    @AndroidFindBy(id = "com.snapchat.android:id/username_or_email_field")
    public MobileElement usernameField;


    @AndroidFindBy(id = "com.snapchat.android:id/password_field")
    public MobileElement passwordField;
    @AndroidFindBy(id="com.snapchat.android:id/nav_button")
    public MobileElement loginAction;

}
