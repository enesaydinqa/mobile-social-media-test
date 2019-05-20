package com.appium.mobile.test.snapchat;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.SnapchatAndroidTest;
import com.appium.pages.snapchat.SendMessage;
import com.appium.pages.snapchat.SnapchatLoginAction;
import com.appium.pages.snapchat.StoryPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class SnapchatStoryTest extends SnapchatAndroidTest {
    private Logger logger = Logger.getLogger(SnapchatStoryTest.class);
    private String user_sender = "testenerjim@gmail.com";
    private String password_sender = "enerjimE1";
    private String name_sender = "mbcmtestuser";
    private String message;

    private StoryPage storyPage;

    private SnapchatLoginAction loginPage;
    private SendMessage sendMessage;


    @Before
    public void init() throws Exception {
        super.init();
        loginSnapchat(firstMobile, user_sender, password_sender);

        storyPage = new StoryPage(firstMobile);
        loginPage = new SnapchatLoginAction(firstMobile);
        sendMessage = new SendMessage(firstMobile);
    }


    @Test
    @Contact(Author.ATIKE)
    public void testCaptureImageStoryAndShare() throws Exception {
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        sendMyStory(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void testCaptureVideoStoryAndShare() throws Exception {
        longPress(firstMobile, storyPage.cameraCaptureButton, 10);
        sendMyStory(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendMessageWithSingleDevice() throws Exception {
        message = "This is a single device test message:" + RandomStringUtils.randomAlphanumeric(10);
        searchAndFindFriends(firstMobile, name_sender);
        sendMessage(firstMobile, message);
        controlReceivedMessage(firstMobile, message);

    }

    @Test
    @Contact(Author.ATIKE)
    public void addImageToStory() throws Exception {

        waitAndClick(firstMobile, storyPage.cameraCaptureButton, true, "picture is taken");
        clickElementInList(storyPage.addStory, 3);
        waitAndClick(firstMobile, storyPage.addToAlert, true, "picture is added to your story");
        getSnapSendDuration();
    }

}

