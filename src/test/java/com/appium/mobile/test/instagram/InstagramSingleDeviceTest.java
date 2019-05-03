package com.appium.mobile.test.instagram;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.client.Constants;
import com.appium.context.app.InstagramAndroidTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.FooterPage;
import com.appium.pages.instagram.LoginPage;
import com.appium.pages.instagram.PostSendPage;
import com.appium.pages.instagram.SearchPage;
import com.appium.utils.InstagramReportGenerate;
import com.appium.utils.ReportInformation;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;

import static com.appium.utils.ReportInformation.instagramPostShareButtonClickTime;
import static com.appium.utils.ReportInformation.instagramSharedImagePostTime;
import static com.appium.utils.ReportInformation.instagramSharedVideoPostTime;
import static com.appium.utils.ReportInformation.mobileDeviceOneGeoLocation;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramSingleDeviceTest extends InstagramAndroidTest
{
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private FooterPage footerPage;
    private PostSendPage postSendPage;
    private SearchPage searchPage;
    private LoginPage loginPage;

    @Rule
    public InstagramReportGenerate screenShootRule = new InstagramReportGenerate();

    @Before
    public void init() throws Exception
    {
        super.init();

        footerPage = new FooterPage(firstMobile);
        postSendPage = new PostSendPage(firstMobile);
        searchPage = new SearchPage(firstMobile);
        loginPage = new LoginPage(firstMobile);
    }

    @Test
    @Contact(Author.ENES)
    public void testSendImagePost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO);

        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        waitAndClick(firstMobile, footerPage.cameraButton);
        waitAndClick(firstMobile, postSendPage.galleryTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);

        instagramPostShareButtonClickTime = waitAndClick(firstMobile, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");
        instagramSharedImagePostTime = waitNotVisible(firstMobile, postSendPage.pendingContainer, true, "Instagram Shared Image Post Time");
    }

    @Test
    @Contact(Author.ENES)
    public void testSendVideoPost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH, RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(firstMobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO);

        mobileDeviceOneGeoLocation = getGeoLocation(configuration.getMobileOneUID());

        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());
        waitAndClick(firstMobile, footerPage.cameraButton);
        waitAndClick(firstMobile, postSendPage.galleryTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);
        waitAndClick(firstMobile, postSendPage.nextTitle);

        instagramPostShareButtonClickTime = waitAndClick(firstMobile, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");
        instagramSharedVideoPostTime = waitNotVisible(firstMobile, postSendPage.pendingContainer, true, "Instagram Shared Video Post Time");
    }

    @Test
    @Contact(Author.SELIM)
    public void testSearchByHashtag() throws InterruptedException {
        //waitNotVisible(firstMobile, loginPage.noneButtonBy);
        waitAndClick(firstMobile, loginPage.noneButtonMobileElement);
        login(firstMobile, configuration.getFirstInstagramTestUser(), configuration.getInstagramTestUserPassword());

        waitAndClick(firstMobile, footerPage.searchButton);
        ReportInformation.hashtagSearchStartTime = waitAndSendKeys(firstMobile, searchPage.searchInput,"#trend", true, "Hashtag Search Start Time");

        ReportInformation.hashtagSearchShowingTime = waitNotVisible(firstMobile, searchPage.searchLoad,true,"Hashtag Search Showing Time");
    }
}
