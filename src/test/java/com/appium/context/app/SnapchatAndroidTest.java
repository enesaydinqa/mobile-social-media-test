package com.appium.context.app;

import com.appium.client.date.DateFormatType;
import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.snapchat.SnapchatSingleDeviceTest;
import com.appium.pages.snapchat.ProfilePage;
import com.appium.pages.snapchat.SendMessagePage;
import com.appium.pages.snapchat.SnapchatLoginPage;
import com.appium.pages.snapchat.StoryPage;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class SnapchatAndroidTest extends AbstractAndroidTest
{
    private Logger logger = Logger.getLogger(SnapchatSingleDeviceTest.class);

    private SnapchatLoginPage loginPage;
    protected ProfilePage profilePage;
    protected StoryPage storyPage;
    protected SendMessagePage sendMessagePage;

    protected void isAlertExist(AppiumDriver driver) throws Exception
    {
        storyPage = new StoryPage(driver);

        if (isMobileElementDisplayedOnPage(storyPage.alert))
        {
            waitAndClick(driver, storyPage.alert);
        }
    }

    protected void login(AppiumDriver driver, String username, String password) throws Exception
    {
        loginPage = new SnapchatLoginPage(driver);

        waitAndClick(driver, loginPage.loginButton);
        waitElementVisible(driver, loginPage.usernameField);
        waitAndClear(driver, loginPage.usernameField);
        waitAndSendKeys(driver, loginPage.usernameField, username);
        waitAndSendKeys(driver, loginPage.passwordField, password);
        waitAndClick(driver, loginPage.loginAction);
        sleep(10);
    }

    protected void goMessagePage(AppiumDriver driver, String friendsName) throws Exception
    {
        storyPage = new StoryPage(driver);
        profilePage = new ProfilePage(driver);

        waitAndClick(driver, storyPage.friends);
        waitAndClick(driver, profilePage.searchFriends);
        waitAndSendKeys(driver, profilePage.searchFriendsText, friendsName);
        waitAndClick(driver, profilePage.firstFriends);
    }

    protected void sendMessage(AppiumDriver driver, String message) throws InterruptedException
    {
        sendMessage(driver, message, false, null);
    }

    protected void sendMessage(AppiumDriver driver, String message, boolean log, String description) throws InterruptedException
    {
        sendMessagePage = new SendMessagePage(driver);

        waitAndSendKeys(driver, sendMessagePage.messageText, message);
        pressEnter(driver, log, description);
    }

    protected void controlReceivedMessage(AppiumDriver driver, String message)
    {
        sendMessagePage = new SendMessagePage(driver);

        int index = getSizeOfList(sendMessagePage.multipleText);

        String receivedMsg = "";

        for (int i = 0; i <= index; i++)
        {
            receivedMsg = getAttribute(getElementInList(sendMessagePage.multipleText, i), "text");
            if (receivedMsg.equals(message))
            {
                assertEqualsText(message, receivedMsg);
                System.out.println(receivedMsg);
                break;
            }
        }
    }

    protected void searchAndFindFriends(AppiumDriver driver, String name) throws Exception
    {
        sendMessagePage = new SendMessagePage(driver);

        sleep(2);
        waitAndClick(driver, sendMessagePage.searchField);
        waitAndSendKeys(driver, sendMessagePage.searchField, name);
        waitAndClick(driver, sendMessagePage.sendMessageUser);
    }

    protected void shareMyStory(AppiumDriver driver) throws Exception
    {
        storyPage = new StoryPage(driver);

        waitAndClick(driver, storyPage.sendButton);
        waitAndClick(driver, storyPage.searchFriends);
        waitAndSendKeys(driver, storyPage.searchFriends, "My Story");
        waitAndClick(driver, storyPage.myStory);
        waitAndClick(driver, storyPage.send, true, "Snapchat Story Share Button Click");
        sleep(configuration.getSnapChatStoryTimeout());
        getSnapSendDuration();
    }

    protected String getSnapSendDuration()
    {
        List<LogEntry> adbLogs = firstMobile.manage().logs().get("logcat").filter(Level.ALL);

        AtomicReference<String> duration = new AtomicReference<>();

        IntStream.range(0, adbLogs.size())
                .filter(i -> adbLogs.get(i).getMessage().contains("removeNotification key=0|com.snapchat.android"))
                .forEach(i -> {
                    duration.set(adbLogs.get(i).getMessage().substring(5, 18));
                    logger.info("Shared Snapchat Story Time : " + getCurrentDate(DateFormatType.YEAR_MONTH_DAY.dateFormat) + duration);
                });

        return String.valueOf(duration);
    }

}
