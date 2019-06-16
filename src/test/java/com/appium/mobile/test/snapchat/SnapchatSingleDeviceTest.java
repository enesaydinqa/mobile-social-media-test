package com.appium.mobile.test.snapchat;

import com.annotations.Author;
import com.annotations.Contact;
import com.annotations.Description;
import com.appium.client.objects.SnapchatReport;
import com.appium.context.app.SnapchatAndroidTest;
import com.appium.pages.snapchat.SendMessagePage;
import com.appium.pages.snapchat.StoryPage;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class SnapchatSingleDeviceTest extends SnapchatAndroidTest
{
    private Logger logger = Logger.getLogger(SnapchatSingleDeviceTest.class);

    private StoryPage storyPage;

    @Before
    public void init() throws Exception
    {
        super.init();

        snapchatReport = new SnapchatReport();

        storyPage = new StoryPage(firstMobile);
        sendMessagePage = new SendMessagePage(firstMobile);

        login(firstMobile, configuration.getFirstSnapChatTestUserName(), configuration.getSnapChatTestUserPassword());
    }

    @Test
    @Contact(Author.ATIKE)
    @Description("Bu test Snapchat de image story atıyor.")
    public void testCaptureImageStoryAndShare() throws Exception
    {
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        isAlertExist(firstMobile);
        shareMyStory(firstMobile, "Image");
    }

    @Test
    @Contact(Author.ATIKE)
    @Description("Bu test Snapchat de video story atıyor.")
    public void testCaptureVideoStoryAndShare() throws Exception
    {
        longPress(firstMobile, storyPage.cameraCaptureButton, 10);
        isAlertExist(firstMobile);
        shareMyStory(firstMobile, "Video");
    }
}