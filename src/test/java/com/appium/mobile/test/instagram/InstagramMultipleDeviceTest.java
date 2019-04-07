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

        homePageOne = new HomePage(driverOne);
        directMessagePageOne = new DirectMessagePage(driverOne);

        homePageSecond = new HomePage(driverSecond);
        directMessagePageSecond = new DirectMessagePage(driverSecond);
    }

    @Test
    public void testSendTextMessage()
    {
        waitAndClick(driverOne, homePageOne.messageButton);
        waitAndClick(driverSecond, homePageSecond.messageButton);
        waitAndClick(driverOne, directMessagePageOne.newMessageButton);
        WaitAndSendKeys(driverOne, directMessagePageOne.searchText, configuration.getInstagramReceiverUsername());
        waitAndClick(driverOne, directMessagePageOne.searchResultUser);
        WaitAndSendKeys(driverOne, directMessagePageOne.messageText, RandomStringUtils.randomAlphabetic(15));
        waitAndClick(driverOne, directMessagePageOne.messageSendButton, true, "Click Send Message Time");
        waitNotVisible(driverOne, directMessagePageOne.sendImage, true, "Send Message Time");

        waitElementVisible(driverSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    public void testSendPhotoMessage()
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(driverOne, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_PROJECT_PATH);

        waitAndClick(driverOne, homePageOne.messageButton);
        waitAndClick(driverSecond, homePageSecond.messageButton);
        waitAndClick(driverOne, directMessagePageOne.newMessageButton);
        WaitAndSendKeys(driverOne, directMessagePageOne.searchText, configuration.getInstagramReceiverUsername());
        waitAndClick(driverOne, directMessagePageOne.searchResultUser);
        waitAndClick(driverOne, directMessagePageOne.galleryButton);
        waitAndClick(driverOne, directMessagePageOne.photoThumbnail);
        waitAndClick(driverOne, directMessagePageOne.sendButton, true, "Click Send Message Time");
        waitNotVisible(driverOne, directMessagePageOne.sendImage, true, "Send Message Time");

        waitElementVisible(driverSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    public void testSendVideoMessage()
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(driverOne, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_PROJECT_PATH);

        waitAndClick(driverOne, homePageOne.messageButton);
        waitAndClick(driverSecond, homePageSecond.messageButton);
        waitAndClick(driverOne, directMessagePageOne.newMessageButton);
        WaitAndSendKeys(driverOne, directMessagePageOne.searchText, configuration.getInstagramReceiverUsername());
        waitAndClick(driverOne, directMessagePageOne.searchResultUser);
        waitAndClick(driverOne, directMessagePageOne.galleryButton);
        waitAndClick(driverOne, directMessagePageOne.videoThumbnail);
        waitAndClick(driverOne, directMessagePageOne.sendButton, true, "Click Send Message Time");
        waitNotVisible(driverOne, directMessagePageOne.sendImage, true, "Send Message Time");

        waitElementVisible(driverSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

}
