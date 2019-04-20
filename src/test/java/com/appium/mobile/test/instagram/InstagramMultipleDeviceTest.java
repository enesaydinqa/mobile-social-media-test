package com.appium.mobile.test.instagram;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.client.Constants;
import com.appium.context.app.InstagramAndroidTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.DirectMessagePage;
import com.appium.pages.instagram.HomePage;
import com.appium.utils.InstagramReportGenerate;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;

import static com.appium.utils.ReportInformation.clickSendMessageTime;
import static com.appium.utils.ReportInformation.mobileDeviceOneGeoLocation;
import static com.appium.utils.ReportInformation.mobileDeviceSecondGeoLocation;
import static com.appium.utils.ReportInformation.receiveMessageTime;
import static com.appium.utils.ReportInformation.sendMessageTime;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramMultipleDeviceTest extends InstagramAndroidTest
{
    private Logger logger = Logger.getLogger(InstagramMultipleDeviceTest.class);

    private HomePage homePageOne;
    private HomePage homePageSecond;
    private DirectMessagePage directMessagePageOne;
    private DirectMessagePage directMessagePageSecond;

    @Rule
    public InstagramReportGenerate screenShootRule = new InstagramReportGenerate();

    @Before
    public void init() throws Exception
    {
        super.init(true);

        homePageOne = new HomePage(firstMobile);
        directMessagePageOne = new DirectMessagePage(firstMobile);

        homePageSecond = new HomePage(secondMobile);
        directMessagePageSecond = new DirectMessagePage(secondMobile);
    }

    @Test
    @Contact(Author.ENES)
    public void testSendTextMessage() throws IOException, InterruptedException
    {
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        mobileDeviceSecondGeoLocation = getGeoLocation(configuration.getMobileSecondUID());

        logger.info(String.format("One Device : %s", mobileDeviceOneGeoLocation));
        logger.info(String.format("Second Device : %s", mobileDeviceSecondGeoLocation));

        waitAndClick(firstMobile, homePageOne.messageButton);
        waitAndClick(secondMobile, homePageSecond.messageButton);
        waitAndClick(firstMobile, directMessagePageOne.newMessageButton);
        waitAndSendKeys(firstMobile, directMessagePageOne.searchText, configuration.getSecondInstagramTestUser());
        waitAndClick(firstMobile, directMessagePageOne.searchResultUser);
        waitAndSendKeys(firstMobile, directMessagePageOne.messageText, RandomStringUtils.randomAlphabetic(15));

        clickSendMessageTime = waitAndClick(firstMobile, directMessagePageOne.messageSendButton, true, "Click Send Message Time");
        sendMessageTime = waitNotVisible(firstMobile, directMessagePageOne.sendImage, true, "Send Message Time");
        receiveMessageTime = waitElementVisible(secondMobile, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    @Contact(Author.ENES)
    public void testSendPhotoMessage() throws IOException, InterruptedException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO);

        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        mobileDeviceSecondGeoLocation = getGeoLocation(configuration.getMobileSecondUID());

        logger.info(String.format("One Device : %s", mobileDeviceOneGeoLocation));
        logger.info(String.format("Second Device : %s", mobileDeviceSecondGeoLocation));

        waitAndClick(firstMobile, homePageOne.messageButton);
        waitAndClick(secondMobile, homePageSecond.messageButton);
        waitAndClick(firstMobile, directMessagePageOne.newMessageButton);
        waitAndSendKeys(firstMobile, directMessagePageOne.searchText, configuration.getSecondInstagramTestUser());
        waitAndClick(firstMobile, directMessagePageOne.searchResultUser);
        waitAndClick(firstMobile, directMessagePageOne.galleryButton);
        waitAndClick(firstMobile, directMessagePageOne.photoThumbnail);

        clickSendMessageTime = waitAndClick(firstMobile, directMessagePageOne.sendButton, true, "Click Send Message Time");
        sendMessageTime = waitNotVisible(firstMobile, directMessagePageOne.sendImage, true, "Send Message Time");
        receiveMessageTime = waitElementVisible(secondMobile, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    @Contact(Author.ENES)
    public void testSendVideoMessage() throws IOException, InterruptedException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO);

        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        mobileDeviceSecondGeoLocation = getGeoLocation(configuration.getMobileSecondUID());

        logger.info(String.format("One Device : %s", mobileDeviceOneGeoLocation));
        logger.info(String.format("Second Device : %s", mobileDeviceSecondGeoLocation));

        waitAndClick(firstMobile, homePageOne.messageButton);
        waitAndClick(secondMobile, homePageSecond.messageButton);
        waitAndClick(firstMobile, directMessagePageOne.newMessageButton);
        waitAndSendKeys(firstMobile, directMessagePageOne.searchText, configuration.getSecondInstagramTestUser());
        waitAndClick(firstMobile, directMessagePageOne.searchResultUser);
        waitAndClick(firstMobile, directMessagePageOne.galleryButton);
        waitAndClick(firstMobile, directMessagePageOne.videoThumbnail);

        clickSendMessageTime = waitAndClick(firstMobile, directMessagePageOne.sendButton, true, "Click Send Message Time");
        sendMessageTime = waitNotVisible(firstMobile, directMessagePageOne.sendImage, true, "Send Message Time");
        receiveMessageTime = waitElementVisible(secondMobile, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

}
