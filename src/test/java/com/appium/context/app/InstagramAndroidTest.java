package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.pages.instagram.LoginPage;
import io.appium.java_client.AppiumDriver;

public abstract class InstagramAndroidTest extends AbstractAndroidTest {

    protected void loginInstagram(AppiumDriver mobile, String username, String password) {

        LoginPage loginPage = new LoginPage(mobile);

        waitAndClick(firstMobile, loginPage.login, true, "Login button is clicked");
        waitAndClick(firstMobile, loginPage.facebook, true, "Login with facebook button is clicked");
        waitAndSendKeys(firstMobile, loginPage.emaill, username);
        waitAndSendKeys(firstMobile, loginPage.password, password);
        waitAndClick(firstMobile, loginPage.loginToFace);
        waitAndClick(firstMobile, loginPage.grandAccess);
    }
}
