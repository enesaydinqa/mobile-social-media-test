package com.appium.mobile.test.snapchat;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.client.date.DateFormatType;
import com.appium.context.app.SnapchatAndroidTest;
import com.appium.pages.snapchat.LogOut;
import com.appium.pages.snapchat.SendMessage;
import com.appium.pages.snapchat.SnapchatLoginAction;
import com.appium.pages.snapchat.StoryPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.logging.LogEntry;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class SnapchatStoryTest extends SnapchatAndroidTest {
    private Logger logger = Logger.getLogger(SnapchatStoryTest.class);

    private StoryPage storyPage;
    //gamze
    private SnapchatLoginAction loginPage;
    private SendMessage sendMessage;
    private LogOut logOut;


    @Before
    public void init() throws Exception {
        super.init();
        loginSnapchat(firstMobile);

        storyPage = new StoryPage(firstMobile);
        loginPage = new SnapchatLoginAction(firstMobile);
        sendMessage = new SendMessage(firstMobile);
        logOut = new LogOut(firstMobile);
    }


    @Test
    public void testCaptureImageStoryAndShare() throws Exception {
        // getGeoLocation(mobileDevice.uid);
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        waitAndClick(firstMobile, storyPage.sendButton);
        clickElementInList(storyPage.myStoryTitle,2);
        waitAndClick(firstMobile, storyPage.send, true, "Snapchat Story Share Button Click");

        sleep(10);
        getSnapSendDuration();
    }



    @Test
    public void testCaptureVideoStoryAndShare() throws Exception {
        //getGeoLocation(mobileDevice.uid);

        longPress(firstMobile, storyPage.cameraCaptureButton, 10);
        waitAndClick(firstMobile, storyPage.sendButton);
        //waitAndClick(firstMobile, storyPage.myStoryTitle);
        clickElementInList(storyPage.myStoryTitle,2);
        waitAndClick(firstMobile, storyPage.send, true, "Snapchat Story Share Button Click");

        sleep(30);
        getSnapSendDuration();

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

    //gamze


    @Test
    public void sendMessageWithSnapchat() throws Exception {

        waitAndClick(firstMobile, sendMessage.searchField);
        waitAndSendKeys(firstMobile, sendMessage.searchField, "mbcmuser2");
        waitAndClick(firstMobile, sendMessage.sendMessageUser);
        waitAndSendKeys(firstMobile, sendMessage.sendAChat, "helloo!! Dont worry its just a test:)");
        keyboardEnter(firstMobile, true);
        //logger.info("test");
        getGeoLocation(configuration.getMobileOneUID());
        swipeScreen(firstMobile, SwipeDirection.RIGHT, 1);
        waitElementVisible(firstMobile, sendMessage.backButton);
        waitAndClick(firstMobile, sendMessage.backButton);

    }


    @After
    public void afterSnapchatTest() throws Exception {
        firstMobile.resetApp();
    }

    @Test
    @Contact(Author.ATIKE)
    public void addImageStory() throws Exception {

        waitAndClick(firstMobile, storyPage.cameraCaptureButton,true,"picture is taken");
        clickElementInList(storyPage.addStory,3);
        waitAndClick(firstMobile, storyPage.addToAlert,true,"picture is added to your story");
        sleep(1);

    }

}
//  waitElementVisible(firstMobile, storyPage.addStory);
// AndroidDriver driverr = (AndroidDriver)firstMobile;
//    sleep(10);
//    Point point = storyPage.myStoryTitle.getLocation();
//    int x = point.x;
//    int y = point.y;
//        System.out.println("korrdinatlar x: " + x + " y: " + y);
//    TouchAction touchAction = new TouchAction(firstMobile);
//        touchAction.press(PointOption.point(x, y)).release().perform();
//    //touchAction.tap(PointOption(x, y)).perform();
//}
