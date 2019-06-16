package com.appium.context.app;

import com.appium.client.objects.InstagramReport;
import com.appium.context.AbstractAndroidTest;
import com.appium.pages.instagram.LoginPage;
import com.appium.utils.ReportInformation;
import io.appium.java_client.AppiumDriver;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public abstract class InstagramAndroidTest extends AbstractAndroidTest
{
    protected InstagramReport instagramReport;
    private LoginPage loginPage;

    @Rule
    public TestWatcher testResults = new TestWatcher()
    {
        @Override
        protected void succeeded(Description description)
        {
            ReportInformation.instagram(description, deviceInfo, instagramReport, true);
        }

        @Override
        protected void failed(Throwable e, Description description)
        {
            ReportInformation.instagram(description, deviceInfo, instagramReport, false);
        }
    };

    protected InstagramAndroidTest login(AppiumDriver driver, String username, String password) throws Exception
    {
        loginPage = new LoginPage(driver);

        sleep(3);

        if (isTextDisplayedOnPage(driver, "CONTINUE"))
        {
            waitAndClick(driver, loginPage.buttonPositive);
        }

        waitAndClick(driver, loginPage.logIn);
        waitAndSendKeys(driver, loginPage.usernameInput, username);
        waitAndSendKeys(driver, loginPage.passwordInput, password);
        waitAndClick(driver, loginPage.loginButton);
        sleep(10);

        return this;
    }
}
