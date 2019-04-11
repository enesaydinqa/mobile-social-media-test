package com.appium.mobile.test.instagram;

import com.appium.client.Constants;
import com.appium.context.AbstractAndroidSingleTest;
import com.appium.context.Events;
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

import java.io.IOException;
import java.net.URISyntaxException;

@Category({ZainInstagram.class, MobilyInstagram.class, STCInstagram.class})
public class InstagramSingleDeviceTest extends AbstractAndroidSingleTest
{
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private FooterPage footerPage;
    private PostSendPage postSendPage;

    @Before
    public void init() throws IOException, URISyntaxException
    {
        super.init();

        footerPage = new FooterPage(mobile);
        postSendPage = new PostSendPage(mobile);
    }

    @Test
    public void testSendImagePost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(
                Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15)
        );

        pushFileMobile(mobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_PROJECT_PATH);

        getGeoLocation(configuration.getMobileOneUID());

        waitAndClick(mobile, footerPage.cameraButton);
        waitAndClick(mobile, postSendPage.nextTitle);
        waitAndClick(mobile, postSendPage.nextTitle);
        waitAndClick(mobile, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");

        waitNotVisible(mobile, postSendPage.pendingContainer, true, "Instagram Shared Image Post Time");
    }

    @Test
    public void testSendVideoPost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(
                Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15)
        );

        pushFileMobile(mobile, mobileFilePath, Constants.InstagramPost.INSTAGRAM_VIDEO_FOR_PROJECT_PATH);

        getGeoLocation(configuration.getMobileOneUID());

        waitAndClick(mobile, footerPage.cameraButton);
        waitAndClick(mobile, postSendPage.nextTitle);
        waitAndClick(mobile, postSendPage.nextTitle);
        waitAndClick(mobile, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");

        waitNotVisible(mobile, postSendPage.pendingContainer, true, "Instagram Shared Video Post Time");
    }
}
