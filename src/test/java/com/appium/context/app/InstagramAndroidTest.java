package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.pages.instagram.LoginPage;
import io.appium.java_client.AppiumDriver;

public class InstagramAndroidTest extends AbstractAndroidTest
{
    protected void login(AppiumDriver driver, String username, String password) throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);

        waitAndClick(driver, loginPage.logIn);
        waitAndSendKeys(driver, loginPage.usernameInput, username);
        waitAndSendKeys(driver, loginPage.passwordInput, password);
        waitAndClick(driver, loginPage.loginButton);
        sleep(5);
    }
}
