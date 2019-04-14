package com.appium.mobile.test.instagram;

import com.appium.client.Constants;
import com.appium.context.AbstractAndroidMultipleTest;
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
public class InstagramMultipleDeviceTest extends AbstractAndroidMultipleTest
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
        super.init();

        homePageOne = new HomePage(mobileOne);
        directMessagePageOne = new DirectMessagePage(mobileOne);

        homePageSecond = new HomePage(mobileSecond);
        directMessagePageSecond = new DirectMessagePage(mobileSecond);
    }

    @Test
    public void testSendTextMessage() throws IOException, InterruptedException
    {
        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        mobileDeviceSecondGeoLocation = getGeoLocation(configuration.getMobileSecondUID());

        logger.info(String.format("One Device : %s", mobileDeviceOneGeoLocation));
        logger.info(String.format("Second Device : %s", mobileDeviceSecondGeoLocation));

        waitAndClick(mobileOne, homePageOne.messageButton);
        waitAndClick(mobileSecond, homePageSecond.messageButton);
        waitAndClick(mobileOne, directMessagePageOne.newMessageButton);
        waitAndSendKeys(mobileOne, directMessagePageOne.searchText, configuration.getInstagramTestUser2());
        waitAndClick(mobileOne, directMessagePageOne.searchResultUser);
        waitAndSendKeys(mobileOne, directMessagePageOne.messageText, RandomStringUtils.randomAlphabetic(15));

        clickSendMessageTime = waitAndClick(mobileOne, directMessagePageOne.messageSendButton, true, "Click Send Message Time");
        sendMessageTime = waitNotVisible(mobileOne, directMessagePageOne.sendImage, true, "Send Message Time");
        receiveMessageTime = waitElementVisible(mobileSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    public void testSendPhotoMessage() throws IOException, InterruptedException
    {
        String mobileFilePath = String.format(
                Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15)
        );

        pushFileMobile(mobileOne, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO);

        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        mobileDeviceSecondGeoLocation = getGeoLocation(configuration.getMobileSecondUID());

        logger.info(String.format("One Device : %s", mobileDeviceOneGeoLocation));
        logger.info(String.format("Second Device : %s", mobileDeviceSecondGeoLocation));

        waitAndClick(mobileOne, homePageOne.messageButton);
        waitAndClick(mobileSecond, homePageSecond.messageButton);
        waitAndClick(mobileOne, directMessagePageOne.newMessageButton);
        waitAndSendKeys(mobileOne, directMessagePageOne.searchText, configuration.getInstagramTestUser2());
        waitAndClick(mobileOne, directMessagePageOne.searchResultUser);
        waitAndClick(mobileOne, directMessagePageOne.galleryButton);
        waitAndClick(mobileOne, directMessagePageOne.photoThumbnail);

        clickSendMessageTime = waitAndClick(mobileOne, directMessagePageOne.sendButton, true, "Click Send Message Time");
        sendMessageTime = waitNotVisible(mobileOne, directMessagePageOne.sendImage, true, "Send Message Time");
        receiveMessageTime = waitElementVisible(mobileSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

    @Test
    public void testSendVideoMessage() throws IOException, InterruptedException
    {
        String mobileFilePath = String.format(
                Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15)
        );

        pushFileMobile(mobileOne, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO);

        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());
        mobileDeviceSecondGeoLocation = getGeoLocation(configuration.getMobileSecondUID());

        logger.info(String.format("One Device : %s", mobileDeviceOneGeoLocation));
        logger.info(String.format("Second Device : %s", mobileDeviceSecondGeoLocation));

        waitAndClick(mobileOne, homePageOne.messageButton);
        waitAndClick(mobileSecond, homePageSecond.messageButton);
        waitAndClick(mobileOne, directMessagePageOne.newMessageButton);
        waitAndSendKeys(mobileOne, directMessagePageOne.searchText, configuration.getInstagramTestUser2());
        waitAndClick(mobileOne, directMessagePageOne.searchResultUser);
        waitAndClick(mobileOne, directMessagePageOne.galleryButton);
        waitAndClick(mobileOne, directMessagePageOne.videoThumbnail);

        clickSendMessageTime = waitAndClick(mobileOne, directMessagePageOne.sendButton, true, "Click Send Message Time");
        sendMessageTime = waitNotVisible(mobileOne, directMessagePageOne.sendImage, true, "Send Message Time");
        receiveMessageTime = waitElementVisible(mobileSecond, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
    }

}
