package com.appium.mobile.test.snapchat;

import com.annotations.Author;
import com.annotations.Contact;
import com.annotations.Description;
import com.appium.context.app.SnapChatAndroidTest;
import com.appium.pages.snapchat.SendMessage;
import com.appium.pages.snapchat.StoryPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SnapChatSingleDeviceTest extends SnapChatAndroidTest
{
    private Logger logger = Logger.getLogger(SnapChatSingleDeviceTest.class);

    private StoryPage storyPage;

    @Before
    public void init() throws Exception
    {
        super.init();

        storyPage = new StoryPage(firstMobile);
        sendMessage = new SendMessage(firstMobile);

        login(firstMobile, configuration.getFirstSnapChatTestUserName(), configuration.getSnapChatTestUserPassword());
    }

    @Test
    @Contact(Author.ATIKE)
    @Description("Bu test SnapChat de image story atıyor.")
    public void testCaptureImageStoryAndShare() throws Exception
    {
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        isAlertExist(firstMobile);
        shareMyStory(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    @Description("Bu test SnapChat de video story atıyor.")
    public void testCaptureVideoStoryAndShare() throws Exception
    {
        longPress(firstMobile, storyPage.cameraCaptureButton, 10);
        isAlertExist(firstMobile);
        shareMyStory(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    @Ignore("Bu senaryoya gerek yok")
    public void sendMessageWithSingleDevice() throws Exception
    {
        String message = "This is a single device test message : " + RandomStringUtils.randomAlphanumeric(10);

        searchAndFindFriends(firstMobile, "mbcmtestuser");
        sendMessage(firstMobile, message);
        controlReceivedMessage(firstMobile, message);
    }

    @Test
    @Contact(Author.ATIKE)
    @Ignore("Bu senaryoya gerek yok")
    public void addImageToStory() throws Exception
    {
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        clickElementInList(storyPage.addStory, 3);
        waitAndClick(firstMobile, storyPage.addToAlert, true, "picture is added to your story");
        getSnapSendDuration();
    }

}