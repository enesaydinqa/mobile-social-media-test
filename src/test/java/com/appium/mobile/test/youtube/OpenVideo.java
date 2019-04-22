package com.appium.mobile.test.youtube;

import com.appium.context.app.YoutubeAndroidTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import com.appium.pages.youtube.FooterPage;
import com.appium.pages.youtube.MainPage;
import com.appium.utils.InstagramReportGenerate;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.context.annotation.Description;

public class OpenVideo extends YoutubeAndroidTest {
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private MainPage mainPage;
    private FooterPage footerPage;


    @Rule
    public InstagramReportGenerate screenShootRule = new InstagramReportGenerate();

    @Before
    public void init() throws Exception
    {
        super.init();

        mainPage = new MainPage(firstMobile);
        footerPage= new FooterPage(firstMobile);

    }

    @Test
    @Description("This start a video")
    public void startVideo() throws Exception{
        logger.info("startVideo test is started");
        waitAndClick(firstMobile,footerPage.mainPageButton,true,"main page button is clicked");
        waitAndClick(firstMobile,mainPage.searchButton,true,"search button is clicked");
        waitAndSendKeys(firstMobile,mainPage.searchText,"şarkı söyleyen kuş");
        waitAndClick(firstMobile,mainPage.firstSearchedRow,true,"first searched row is clicked");
        waitAndClick(firstMobile,mainPage.firstVideo,true,"first video is clicked");
        sleep(5);
    }
}
