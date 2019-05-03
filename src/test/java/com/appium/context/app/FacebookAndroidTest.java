package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.pages.facebook.LoginPage;
import io.appium.java_client.AppiumDriver;

public class FacebookAndroidTest extends AbstractAndroidTest {
    //login için fonksiyon yaz
    protected void loginFacebook(AppiumDriver driver, String Username, String Password) throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);

        waitAndClick(driver, loginPage.loginButton);
        waitAndSendKeys(driver, loginPage.userName, Username);
        waitAndSendKeys(driver, loginPage.password, Password);
        waitAndClick(driver, loginPage.loginButton);
        sleep(5);
    }
}
