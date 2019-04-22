package com.appium.pages.instagram;

import com.appium.pages.snapchat.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

public class LoginPage extends PageObject {
    public LoginPage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindAll({//kkkk
            @AndroidBy(id= "com.instagram.android:id/log_in_button"),
           // @AndroidBy(xpath = "//android.widget.ImageView[@content-desc='1 unread message']")
    })
    public MobileElement login;

    @AndroidFindAll({//
            @AndroidBy(id= "com.instagram.android:id/login_facebook"),
    })
    public MobileElement facebook;

    @AndroidFindAll({
            @AndroidBy(className= "android.widget.EditText"),
    })
    public MobileElement emaill;


    @AndroidFindAll({
            @AndroidBy(xpath= "//android.widget.EditText[2]"),
    })
    public MobileElement password;


    @AndroidFindAll({
            @AndroidBy(xpath= "//android.widget.Button[@content-desc='Giriş Yap']"),
    })
    public MobileElement loginToFace;


    @AndroidFindAll({
            @AndroidBy(xpath= "//android.widget.Button[last()-1]"),
    })
    public MobileElement grandAccess;


    @AndroidFindAll({
            @AndroidBy(xpath= "//android.view.View[@content-desc='Instagram'a bağlanmak için Facebook hesabına giriş yap']"),
    })
    public MobileElement sendAway;





}
