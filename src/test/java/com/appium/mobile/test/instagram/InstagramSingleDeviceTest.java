package com.appium.mobile.test.instagram;

import com.annotations.Author;
import com.annotations.Contact;
import com.annotations.Description;
import com.appium.client.Constants;
import com.appium.client.objects.InstagramReport;
import com.appium.context.app.InstagramAndroidTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.FooterPage;
import com.appium.pages.instagram.PostSendPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramSingleDeviceTest extends InstagramAndroidTest
{
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private FooterPage footerPage;
    private PostSendPage postSendPage;

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
    @Description("Bu test instagramda image post atıyor.")
    public void testSendImagePost() throws Exception
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO);

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        waitAndClick(firstMobile, footerPage.cameraButton);
        waitAndClick(firstMobile, postSendPage.nextTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);

        String instagramPostShareButtonClickTime = waitAndClick(firstMobile, postSendPage.nextTitle, true, "instagram post share button click time");
        instagramReport.setInstagramPostShareButtonClickTime(instagramPostShareButtonClickTime);

        String instagramSharedImagePostTime = waitNotVisible(firstMobile, postSendPage.pendingContainer, true, "instagram shared image post time");
        instagramReport.setInstagramSharedImagePostTime(instagramSharedImagePostTime);
    }

    @Test
    @Contact(Author.ENES)
    @Description("Bu test instagramda video post atıyor.")
    public void testSendVideoPost() throws Exception
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO);

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
