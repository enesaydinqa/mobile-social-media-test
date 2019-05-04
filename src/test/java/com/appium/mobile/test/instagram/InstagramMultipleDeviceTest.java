package com.appium.mobile.test.instagram;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.client.Constants;
import com.appium.client.objects.InstagramReport;
import com.appium.context.app.InstagramAndroidTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.DirectMessagePage;
import com.appium.pages.instagram.HomePage;
import com.appium.utils.ReportGenerate;
import com.appium.utils.ReportInformation;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramMultipleDeviceTest extends InstagramAndroidTest
{
    private Logger logger = Logger.getLogger(InstagramMultipleDeviceTest.class);

    private HomePage homePageOne;
    private HomePage homePageSecond;
    private DirectMessagePage directMessagePageOne;
    private DirectMessagePage directMessagePageSecond;
    private InstagramReport instagramReport;

    @Rule
    public ReportGenerate screenShootRule = new ReportGenerate()
    {
        @Override
        public void reportInformation(ExtentTest test)
        {
            ReportInformation.instagramReportFill(deviceInfo, instagramReport, test);
        }
    };

    @Before
    public void init() throws Exception
    {
        super.init(true);

        homePageOne = new HomePage(firstMobile);
        directMessagePageOne = new DirectMessagePage(firstMobile);

        homePageSecond = new HomePage(secondMobile);
        directMessagePageSecond = new DirectMessagePage(secondMobile);

        instagramReport = new InstagramReport();
    }

    @Test
    @Contact(Author.ENES)
    public void testSendTextMessage() throws Exception
    {
        deviceInfo.setMobileDeviceOneGeoLocation(getGeoLocation(configuration.getMobileOneUID()));
        deviceInfo.setMobileDeviceSecondGeoLocation(getGeoLocation(configuration.getMobileSecondUID()));

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        login(secondMobile, configuration.getSecondInstagramTestUser(), configuration.getInstagramTestUserPassword());

        waitAndClick(firstMobile, homePageOne.messageButton);
        waitAndClick(secondMobile, homePageSecond.messageButton);
        waitAndClick(firstMobile, directMessagePageOne.newMessageButton);
        waitAndSendKeys(firstMobile, directMessagePageOne.searchText, configuration.getSecondInstagramTestUser());
        waitAndClick(firstMobile, directMessagePageOne.searchResultUser);
        waitAndSendKeys(firstMobile, directMessagePageOne.messageText, RandomStringUtils.randomAlphabetic(15));

        String clickSendMessageTime = waitAndClick(firstMobile, directMessagePageOne.messageSendButton, true, "Click Send Message Time");
        instagramReport.setClickSendMessageTime(clickSendMessageTime);

        String sendMessageTime = waitNotVisible(firstMobile, directMessagePageOne.sendImage, true, "Send Message Time");
        instagramReport.setSendMessageTime(sendMessageTime);

        String receiveMessageTime = waitElementVisible(secondMobile, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
        instagramReport.setReceiveMessageTime(receiveMessageTime);
    }

    @Test
    @Contact(Author.ENES)
    public void testSendPhotoMessage() throws Exception
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO);

        deviceInfo.setMobileDeviceOneGeoLocation(getGeoLocation(configuration.getMobileOneUID()));
        deviceInfo.setMobileDeviceSecondGeoLocation(getGeoLocation(configuration.getMobileSecondUID()));

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        login(secondMobile, configuration.getSecondInstagramTestUser(), configuration.getInstagramTestUserPassword());

        waitAndClick(firstMobile, homePageOne.messageButton);
        waitAndClick(secondMobile, homePageSecond.messageButton);
        waitAndClick(firstMobile, directMessagePageOne.newMessageButton);
        waitAndSendKeys(firstMobile, directMessagePageOne.searchText, configuration.getSecondInstagramTestUser());
        waitAndClick(firstMobile, directMessagePageOne.searchResultUser);
        waitAndClick(firstMobile, directMessagePageOne.galleryButton);
        waitAndClick(firstMobile, directMessagePageOne.photoThumbnail);

        String clickSendMessageTime = waitAndClick(firstMobile, directMessagePageOne.sendButton, true, "Click Send Message Time");
        instagramReport.setClickSendMessageTime(clickSendMessageTime);

        String sendMessageTime = waitNotVisible(firstMobile, directMessagePageOne.sendImage, true, "Send Message Time");
        instagramReport.setSendMessageTime(sendMessageTime);

        String receiveMessageTime = waitElementVisible(secondMobile, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
        instagramReport.setReceiveMessageTime(receiveMessageTime);
    }

    @Test
    @Contact(Author.ENES)
    public void testSendVideoMessage() throws Exception
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO);

        deviceInfo.setMobileDeviceOneGeoLocation(getGeoLocation(configuration.getMobileOneUID()));
        deviceInfo.setMobileDeviceSecondGeoLocation(getGeoLocation(configuration.getMobileSecondUID()));

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        login(secondMobile, configuration.getSecondInstagramTestUser(), configuration.getInstagramTestUserPassword());

        waitAndClick(firstMobile, homePageOne.messageButton);
        waitAndClick(secondMobile, homePageSecond.messageButton);
        waitAndClick(firstMobile, directMessagePageOne.newMessageButton);
        waitAndSendKeys(firstMobile, directMessagePageOne.searchText, configuration.getSecondInstagramTestUser());
        waitAndClick(firstMobile, directMessagePageOne.searchResultUser);
        waitAndClick(firstMobile, directMessagePageOne.galleryButton);
        waitAndClick(firstMobile, directMessagePageOne.videoThumbnail);

        String clickSendMessageTime = waitAndClick(firstMobile, directMessagePageOne.sendButton, true, "Click Send Message Time");
        instagramReport.setClickSendMessageTime(clickSendMessageTime);

        String sendMessageTime = waitNotVisible(firstMobile, directMessagePageOne.sendImage, true, "Send Message Time");
        instagramReport.setSendMessageTime(sendMessageTime);

        String receiveMessageTime = waitElementVisible(secondMobile, directMessagePageSecond.secondAgoMessageText, true, "Receive Message Time");
        instagramReport.setReceiveMessageTime(receiveMessageTime);
    }

}
