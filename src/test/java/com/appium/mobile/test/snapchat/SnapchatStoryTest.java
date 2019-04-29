package com.appium.mobile.test.snapchat;

import com.appium.client.date.DateFormatType;
import com.appium.context.app.SnapchatAndroidTest;
import com.appium.pages.snapchat.LogOut;
import com.appium.pages.snapchat.SendMessage;
import com.appium.pages.snapchat.SnapchatLoginAction;
import com.appium.pages.snapchat.StoryPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.logging.LogEntry;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.stream.IntStream;

import static com.appium.utils.ReportInformation.mobileDeviceOneGeoLocation;

public class SnapchatStoryTest extends SnapchatAndroidTest {
    private Logger logger = Logger.getLogger(SnapchatStoryTest.class);

    private StoryPage storyPage;
    private SnapchatLoginAction loginPage;
    private SendMessage sendMessage;
    private LogOut logOut;

    @Before
    public void init() throws Exception {
        super.init();

        storyPage = new StoryPage(firstMobile);
        loginPage = new SnapchatLoginAction(firstMobile);
        sendMessage = new SendMessage(firstMobile);
        logOut = new LogOut(firstMobile);
    }

    @Test
    public void testCaptureSnapchatLoginAction() throws InterruptedException, IOException {

        waitAndClick(firstMobile, loginPage.loginButton);
        waitElementVisible(firstMobile, loginPage.usernameField);
        waitAndClearInput(loginPage.usernameField);
        waitAndSendKeys(firstMobile, loginPage.usernameField, "mbcmtestuser");
        waitAndSendKeys(firstMobile, loginPage.passwordField, "mbcm1234");
        waitAndClick(firstMobile, loginPage.loginAction);
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());


    }

    @Test
    public void testCaptureImageStoryAndShare() throws InterruptedException, IOException {
        //getGeoLocation(mobileDevice.uid);
        testCaptureSnapchatLoginAction();
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        waitAndClick(firstMobile, storyPage.sendButton);
        waitAndClick(firstMobile, storyPage.myStoryTitle);
        waitAndClick(firstMobile, storyPage.send, true, "Snapchat Story Share Button Click");
        sleep(10);
        getSnapSendDuration();
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        testCaptureLogoutAction();
    }

    @Test
    public void testCaptureVideoStoryAndShare() throws InterruptedException, IOException {
        //getGeoLocation(mobileDevice.uid);
        testCaptureSnapchatLoginAction();
        waitElementVisible(firstMobile, storyPage.cameraCaptureButton);
        longPress(firstMobile, storyPage.cameraCaptureButton, 10);
        waitAndClick(firstMobile, storyPage.sendButton);
        waitAndClick(firstMobile, storyPage.myStoryTitle);
        waitAndClick(firstMobile, storyPage.send, true, "Snapchat Story Share Button Click");
        sleep(30);
        getSnapSendDuration();
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        testCaptureLogoutAction();
    }

    @Test
    public void testCaptureSendMessage() throws InterruptedException, IOException {
        testCaptureSnapchatLoginAction();
        waitAndClick(firstMobile, sendMessage.searchField);
        waitAndSendKeys(firstMobile, sendMessage.searchField, "mbcmuser2");
        waitAndClick(firstMobile, sendMessage.sendMessageUser);
        waitAndSendKeys(firstMobile, sendMessage.sendAChat, "helloo!! Dont worry its just a test:)");
        keyboardEnter(firstMobile, true);
        //logger.info("test");
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        swipeScreen(firstMobile, SwipeDirection.RIGHT, 1);
        waitElementVisible(firstMobile,sendMessage.backButton);
        waitAndClick(firstMobile,sendMessage.backButton);
        testCaptureLogoutAction();
    }

    @Test
    public void testCaptureLogoutAction() {
        waitAndClick(firstMobile, logOut.userProfileButton);
        if (!isDisplayed(firstMobile, logOut.userProfileButton)) {
            waitAndClick(firstMobile, logOut.storyButton);
        }
        waitAndClick(firstMobile, logOut.settingButton);
        if (!isDisplayed(firstMobile, logOut.logoutButton)) {
            scrollHalfPageDown(firstMobile);
        } else
            waitAndClick(firstMobile, logOut.logoutButton);

    }

    private String getSnapSendDuration() {
        List<LogEntry> adbLogs = firstMobile.manage().logs().get("logcat").filter(Level.ALL);

        AtomicReference<String> duration = new AtomicReference<>();

        IntStream.range(0, adbLogs.size())
                .filter(i -> adbLogs.get(i).getMessage().contains("PhoneStatusBar: removeNotification key=0|com.snapchat.android"))
                .forEach(i -> {
                    duration.set(adbLogs.get(i).getMessage().substring(5, 18));
                    logger.info("Shared Snapchat Story Time : " + getCurrentDate(DateFormatType.YEAR_MONTH_DAY.dateFormat) + duration);
                });

        return String.valueOf(duration);
    }

}
