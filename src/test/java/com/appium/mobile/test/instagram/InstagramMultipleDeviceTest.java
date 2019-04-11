package com.appium.mobile.test.instagram;

import com.appium.client.Constants;
import com.appium.context.AbstractAndroidMultipleTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.DirectMessagePage;
import com.appium.pages.instagram.HomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.net.URISyntaxException;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramMultipleDeviceTest extends AbstractAndroidMultipleTest
{
    private HomePage homePageOne;
    private HomePage homePageSecond;
    private DirectMessagePage directMessagePageOne;
    private DirectMessagePage directMessagePageSecond;

    @Before
    public void init() throws IOException, URISyntaxException
    {
        super.init();

        homePageOne = new HomePage(mobileOne);
        directMessagePageOne = new DirectMessagePage(mobileOne);

        homePageSecond = new HomePage(mobileSecond);
        directMessagePageSecond = new DirectMessagePage(mobileSecond);
    }

    @Test
    public void testSendTextMessage()
    {
        waitAndClick(mobileOne, homePageOne.messageButton);
        waitAndClick(mobileSecond, homePageSecond.messageButton);
        waitAndClick(mobileOne, directMessagePageOne.newMessageButton);
        WaitAndSendKeys(mobileOne, directMessagePageOne.searchText, configuration.getInstagramReceiverUsername());
        waitAndClick(mobileOne, directMessagePageOne.searchResultUser);
        WaitAndSendKeys(mobileOne, directMessagePageOne.messageText, RandomStringUtils.randomAlphabetic(15));
        waitAndClick(mobileOne, directMessagePageOne.messageSendButton, true, "Click Send Message Time");
        waitNotVisible(mobileOne, directMessagePageOne.sendImage, true, "Send Message Time");

        waitElementVisible(mobileSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    public void testSendPhotoMessage()
    {
        String mobileFilePath = String.format(
                Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15)
        );

        pushFileMobile(mobileOne, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_PROJECT_PATH);

        waitAndClick(mobileOne, homePageOne.messageButton);
        waitAndClick(mobileSecond, homePageSecond.messageButton);
        waitAndClick(mobileOne, directMessagePageOne.newMessageButton);
        WaitAndSendKeys(mobileOne, directMessagePageOne.searchText, configuration.getInstagramReceiverUsername());
        waitAndClick(mobileOne, directMessagePageOne.searchResultUser);
        waitAndClick(mobileOne, directMessagePageOne.galleryButton);
        waitAndClick(mobileOne, directMessagePageOne.photoThumbnail);
        waitAndClick(mobileOne, directMessagePageOne.sendButton, true, "Click Send Message Time");
        waitNotVisible(mobileOne, directMessagePageOne.sendImage, true, "Send Message Time");

        waitElementVisible(mobileSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    public void testSendVideoMessage()
    {
        String mobileFilePath = String.format(
                Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15)
        );

        pushFileMobile(mobileOne, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_PROJECT_PATH);

        waitAndClick(mobileOne, homePageOne.messageButton);
        waitAndClick(mobileSecond, homePageSecond.messageButton);
        waitAndClick(mobileOne, directMessagePageOne.newMessageButton);
        WaitAndSendKeys(mobileOne, directMessagePageOne.searchText, configuration.getInstagramReceiverUsername());
        waitAndClick(mobileOne, directMessagePageOne.searchResultUser);
        waitAndClick(mobileOne, directMessagePageOne.galleryButton);
        waitAndClick(mobileOne, directMessagePageOne.videoThumbnail);
        waitAndClick(mobileOne, directMessagePageOne.sendButton, true, "Click Send Message Time");
        waitNotVisible(mobileOne, directMessagePageOne.sendImage, true, "Send Message Time");

        waitElementVisible(mobileSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

}
