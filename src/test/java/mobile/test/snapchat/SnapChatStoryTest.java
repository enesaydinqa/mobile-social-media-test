package mobile.test.snapchat;

import client.date.DateFormatType;
import context.AbstractAndroidSingleTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.logging.LogEntry;
import pages.snapchat.StoryPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class SnapChatStoryTest extends AbstractAndroidSingleTest
{
    private Logger logger = Logger.getLogger(SnapChatStoryTest.class);

    private StoryPage storyPage;

    @Before
    public void init() throws IOException, URISyntaxException
    {
        super.init();

        storyPage = new StoryPage(driver);
    }

    @Test
    public void testCaptureImageStoryAndShare() throws InterruptedException, IOException
    {
        getGeoLocation(mobileDevice.uid);

        waitAndClick(driver, storyPage.cameraCaptureButton);
        waitAndClick(driver, storyPage.sendButton);
        waitAndClick(driver, storyPage.myStoryTitle);
        waitAndClick(driver, storyPage.send, true, "Snapchat Story Share Button Click");

        sleep(10);
        getSnapSendDuration();
    }

    @Test
    public void testCaptureVideoStoryAndShare() throws InterruptedException, IOException
    {
        getGeoLocation(mobileDevice.uid);

        longPress(driver, storyPage.cameraCaptureButton, 10);
        waitAndClick(driver, storyPage.sendButton);
        waitAndClick(driver, storyPage.myStoryTitle);
        waitAndClick(driver, storyPage.send, true, "Snapchat Story Share Button Click");

        sleep(30);
        getSnapSendDuration();

    }

    private String getSnapSendDuration()
    {
        List<LogEntry> adbLogs = driver.manage().logs().get("logcat").filter(Level.ALL);

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
