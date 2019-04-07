package com.appium.mobile.test.instagram;

import com.appium.client.Constants;
import com.appium.context.AbstractAndroidSingleTest;
import com.appium.flag.MobilyInstagram;
import com.appium.flag.STCInstagram;
import com.appium.flag.ZainInstagram;
import com.appium.pages.instagram.FooterPage;
import com.appium.pages.instagram.PostSendPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.net.URISyntaxException;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramSingleDeviceTest extends AbstractAndroidSingleTest
{
    private FooterPage footerPage;
    private PostSendPage postSendPage;

    @Before
    public void init() throws IOException, URISyntaxException
    {
        super.init();

        footerPage = new FooterPage(driver);
        postSendPage = new PostSendPage(driver);
    }

    @Test
    public void testSendImagePost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(driver, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_PROJECT_PATH);

        getGeoLocation();

        waitAndClick(driver, footerPage.cameraButton);
        waitAndClick(driver, postSendPage.nextTitle);
        waitAndClick(driver, postSendPage.nextTitle);
        waitAndClick(driver, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");

        waitNotVisible(driver, postSendPage.pendingContainer, true, "Instagram Shared Image Post Time");
    }

    @Test
    public void testSendVideoPost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(driver, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_PROJECT_PATH);

        //getGeoLocation(mobileDevice.uid);

        waitAndClick(driver, footerPage.cameraButton);
        waitAndClick(driver, postSendPage.nextTitle);
        waitAndClick(driver, postSendPage.nextTitle);
        waitAndClick(driver, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");

        waitNotVisible(driver, postSendPage.pendingContainer, true, "Instagram Shared Video Post Time");
    }
}
