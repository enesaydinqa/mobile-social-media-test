package mobile.test.instagram;

import client.Constants;
import client.flag.MobilyInstagram;
import client.flag.STCInstagram;
import client.flag.ZainInstagram;
import context.AbstractAndroidSingleTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.instagram.FooterPage;
import pages.instagram.PostSendPage;

import java.io.IOException;
import java.net.URISyntaxException;

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
    @Category({STCInstagram.class, MobilyInstagram.class, ZainInstagram.class})
    public void testSendImagePost() throws InterruptedException, IOException
    {
        String mobileFilePath = String.format(Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_MOBILE_PATH,
                RandomStringUtils.randomAlphabetic(15));

        pushFileMobile(driver, mobileFilePath, Constants.InstagramPost.INSTAGRAM_PHOTO_FOR_PROJECT_PATH);

        //getGeoLocation(mobileDevice.uid);

        waitAndClick(driver, footerPage.cameraButton);
        waitAndClick(driver, postSendPage.nextTitle);
        waitAndClick(driver, postSendPage.nextTitle);
        waitAndClick(driver, postSendPage.nextTitle, true, "Instagram Post Share Button Click Time");

        waitNotVisible(driver, postSendPage.pendingContainer, true, "Instagram Shared Image Post Time");
    }

    @Test
    @Category({STCInstagram.class, MobilyInstagram.class, ZainInstagram.class})
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
