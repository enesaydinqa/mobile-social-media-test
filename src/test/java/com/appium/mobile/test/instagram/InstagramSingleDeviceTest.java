package com.appium.mobile.test.instagram;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.client.Constants;
import com.appium.client.objects.InstagramReport;
import com.appium.context.app.InstagramAndroidTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.FooterPage;
import com.appium.pages.instagram.PostSendPage;
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
public class InstagramSingleDeviceTest extends InstagramAndroidTest
{
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private FooterPage footerPage;
    private PostSendPage postSendPage;
    private InstagramReport instagramReport;

    @Rule
    public ReportGenerate reportGenerate = new ReportGenerate()
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
        super.init();

        footerPage = new FooterPage(firstMobile);
        postSendPage = new PostSendPage(firstMobile);

        instagramReport = new InstagramReport();
    }

    @Test
    @Contact(Author.ENES)
    public void testSendImagePost() throws Exception
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO);

        deviceInfo.setMobileDeviceOneGeoLocation(getGeoLocation(configuration.getMobileOneUID()));

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        waitAndClick(firstMobile, footerPage.cameraButton);
        waitAndClick(firstMobile, postSendPage.nextTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);

        String instagramPostShareButtonClickTime = waitAndClick(firstMobile, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");
        instagramReport.setInstagramPostShareButtonClickTime(instagramPostShareButtonClickTime);

        String instagramSharedImagePostTime = waitNotVisible(firstMobile, postSendPage.pendingContainer, true, "Instagram Shared Image Post Time");
        instagramReport.setInstagramSharedImagePostTime(instagramSharedImagePostTime);
    }

    @Test
    @Contact(Author.ENES)
    public void testSendVideoPost() throws Exception
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO);

        deviceInfo.setMobileDeviceOneGeoLocation(getGeoLocation(configuration.getMobileOneUID()));

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        waitAndClick(firstMobile, footerPage.cameraButton);
        waitAndClick(firstMobile, postSendPage.nextTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);

        String instagramPostShareButtonClickTime = waitAndClick(firstMobile, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");
        instagramReport.setInstagramPostShareButtonClickTime(instagramPostShareButtonClickTime);

        String instagramSharedVideoPostTime = waitNotVisible(firstMobile, postSendPage.pendingContainer, true, "Instagram Shared Video Post Time");
        instagramReport.setInstagramSharedVideoPostTime(instagramSharedVideoPostTime);
    }
}
