package com.appium.context.app;

import com.appium.client.date.DateFormatType;
import com.appium.client.objects.TwitterReport;
import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.twitter.TwitterSingleDeviceTest;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class TwitterAndroidTest extends AbstractAndroidTest
{
    public Logger logger = Logger.getLogger(TwitterSingleDeviceTest.class);

    protected TwitterReport twitterReport;
    private LoginPage loginPage;
    private HomePage homePage;

    protected void loginIn(AppiumDriver driver, String username, String password) throws Exception
    {
        if (loginPage == null) loginPage = new LoginPage(driver);

        sleep(10);

        int y = (loginPage.loginLink.getLocation().getY() + loginPage.loginLink.getLocation().getY() + loginPage.loginLink.getSize().height) / 2;
        int x = loginPage.loginLink.getLocation().getX() + loginPage.loginLink.getSize().width - (loginPage.loginLink.getLocation().getX() +
                loginPage.loginLink.getLocation().getX() + loginPage.loginLink.getSize().width) / 10;

        coordinateWithClick(driver, x, y);
        waitAndClear(driver, loginPage.emailInput);
        waitAndSendKeys(driver, loginPage.emailInput, username);
        waitAndClear(driver, loginPage.passwordInput);
        waitAndSendKeys(driver, loginPage.passwordInput, password);
        waitAndClick(driver, loginPage.loginButton, true, "Login Button Click");
    }

    protected void logOutFromTwitter(AppiumDriver driver) throws Exception
    {
        if (homePage == null) homePage = new HomePage(driver);

        waitAndClick(driver, homePage.threeLineButton);
        waitAndClick(driver, homePage.settingsTitle);
        waitAndClick(driver, homePage.accountTitle);
        scrollHalfPageDown(driver);
        waitAndClick(driver, homePage.logoutTitle);
        waitAndClick(driver, homePage.okButton);
    }

    protected void writeAndSentTweet(AppiumDriver driver) throws Exception
    {
        if (homePage == null) homePage = new HomePage(driver);

        sleep(5);
        waitAndClick(driver, homePage.tweetButton);
        waitAndSendKeys(driver, homePage.tweetText, RandomStringUtils.randomAlphanumeric(100));
        waitAndClick(driver, homePage.buttonTweetButton, true, "Tweet Send Button Is Clicked Time");
        getSendTweetDuration();
    }

    private String getSendTweetDuration()
    {
        List<LogEntry> adbLogs = firstMobile.manage().logs().get("logcat").filter(Level.ALL);

        AtomicReference<String> duration = new AtomicReference<>();

        IntStream.range(0, adbLogs.size())
                .filter(i -> adbLogs.get(i).getMessage().contains("PhoneStatusBar: removeNotification key=0|com.twitter.android"))
                .forEach(i -> {
                    duration.set(adbLogs.get(i).getMessage().substring(5, 18));
                    logger.info("Tweet Shared Time : " + getCurrentDate(DateFormatType.YEAR_MONTH_DAY.dateFormat) + duration);
                });

        return String.valueOf(duration);
    }

}
