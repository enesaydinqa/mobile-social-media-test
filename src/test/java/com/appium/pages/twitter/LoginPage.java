package com.appium.pages.twitter;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageObject {

    public LoginPage(AppiumDriver driver){super(driver);}

    @AndroidFindAll({
            @AndroidBy(id="com.twitter.android:id/detail_text"),
          //  @AndroidBy(id= "com.twitter.android:id/sign_in_text")
    })
    public MobileElement  loginLink;

    @AndroidFindBy(id="com.twitter.android:id/login_login")
    public MobileElement loginButton;

    @AndroidFindBy(id="com.twitter.android:id/login_identifier")
    public  MobileElement email;

    @AndroidFindBy(id="com.twitter.android:id/login_password")
    public MobileElement password;

}
