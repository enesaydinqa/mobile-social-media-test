package com.appium.mobile.test.snapchat;

import com.appium.client.date.DateFormatType;
import com.appium.context.app.SnapchatAndroidTest;
import com.appium.pages.snapchat.StoryPage;
import com.appium.utils.SnapchatReportGenerate;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
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
    public static String firstFilter;
    public static String secondFilter;
    public static String cameraButtonClickTime;
    public static String swipeButtonClickTime;


    private StoryPage storyPage;
    @Rule
    public SnapchatReportGenerate screenShootRule = new SnapchatReportGenerate();

    @Before
    public void init() throws Exception {
        super.init();

        storyPage = new StoryPage(firstMobile);
    }

    @Test
    public void testCaptureImageStoryAndShare() throws InterruptedException, IOException {
        // getGeoLocation(mobileDevice.uid);

        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        waitAndClick(firstMobile, storyPage.sendButton);
        waitAndClick(firstMobile, storyPage.myStoryTitle);
        waitAndClick(firstMobile, storyPage.send, true, "Snapchat Story Share Button Click");

        sleep(10);
        getSnapSendDuration();
    }

    @Test
    public void testCaptureVideoStoryAndShare() throws InterruptedException, IOException {
        //getGeoLocation(mobileDevice.uid);

        longPress(firstMobile, storyPage.cameraCaptureButton, 10);
        waitAndClick(firstMobile, storyPage.sendButton);
        waitAndClick(firstMobile, storyPage.myStoryTitle);
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

    @Test
    public void useFilters() throws InterruptedException, IOException {
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        cameraButtonClickTime = waitAndClick(firstMobile, storyPage.lensButton, true, "camera capture button is clicked");
        swipeToElement(firstMobile, storyPage.firstFilterButton, true);
        swipeButtonClickTime=getCurrentDate(DateFormatType.FULL_DATE.dateFormat);
        sleep(2);
        firstFilter = screenshot(firstMobile);
        swipeToElement(firstMobile, storyPage.firstFilterButton, true);
        sleep(2);
        secondFilter = screenshot(firstMobile);

    }
}
