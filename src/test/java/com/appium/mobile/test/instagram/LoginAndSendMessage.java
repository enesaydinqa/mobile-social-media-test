package com.appium.mobile.test.instagram;


import com.appium.context.app.InstagramAndroidTest;
import com.appium.pages.instagram.*;
import com.appium.utils.InstagramReportGenerate;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



public class LoginAndSendMessage extends InstagramAndroidTest {

    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private FooterPage footerPage;
    private DirectMessagePage directMessagePage;
    private SearchPage searchPage;
    private String username;
    private String password;
    private String userThatTakeMessage="atike8989krkmz";
    private String messageText="This is social media testing message.";

    @Rule
    public InstagramReportGenerate screenShootRule = new InstagramReportGenerate();

    @Before
    public void init() throws Exception
    {
        super.init();

        footerPage = new FooterPage(firstMobile);
        directMessagePage =new DirectMessagePage(firstMobile);
        searchPage = new SearchPage(firstMobile);
        username = configuration.configProps.getProperty("instagram.atike.test.user");
        password = configuration.configProps.getProperty("instagram.atike.test.password");
    }

    @Test
    public void basicTest() throws Exception {

        loginInstagram(firstMobile, username, password);

        waitAndClick(firstMobile, footerPage.searchButton);

        logger.info("send message to user");
        waitAndSendKeys(firstMobile, searchPage.searchText,userThatTakeMessage);

        waitAndClick(firstMobile, searchPage.firstSearchedOne);

        waitAndClick(firstMobile, searchPage.sendMessageButton);

        waitAndSendKeys(firstMobile, directMessagePage.messageText,messageText);

        waitAndClick(firstMobile, directMessagePage.sendButton);

        sleep(5);
    }
}
