package com.appium.mobile.test.facebook;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.FacebookAndroidTest;
import com.appium.mobile.test.instagram.InstagramMultipleDeviceTest;
import com.appium.pages.SearchPage;
import com.appium.pages.facebook.HomePage;
import com.appium.pages.facebook.LoginPage;
import com.appium.pages.facebook.MessagePage;
import com.appium.pages.facebook.SharePage;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FacebookMultipleDeviceTest extends FacebookAndroidTest {

    private Logger logger = Logger.getLogger(InstagramMultipleDeviceTest.class);
    private LoginPage loginPage;
    private HomePage homePage;
    private SharePage sharePage;
    private SearchPage searchPage;
    private MessagePage messagePage;

    @Before
    public void init() throws Exception
    {
        super.init();

        loginPage = new LoginPage(firstMobile);
        homePage = new HomePage(firstMobile);
        sharePage = new SharePage(firstMobile);
        searchPage = new SearchPage(firstMobile);
        messagePage = new MessagePage(firstMobile);
    }

    @Test
    @Contact(Author.SELIM)
    public void testSendMessage() throws InterruptedException, IOException {

        waitAndClick(firstMobile, loginPage.selectUser);
        //waitAndClick(firstMobile, homePage.messageButton);
//        waitAndClick(secondMobile, loginPage2.selectUser);
//        waitAndClick(secondMobile, homePage2.messageButton);
        waitAndClick(firstMobile, homePage.searchButton);
        waitAndSendKeys(firstMobile, homePage.searchText, "Ahmet Yılmaz");
        //waitAndClick(firstMobile, homePage.searchUserMessageButton);
        waitAndSendKeys(firstMobile, messagePage.messageText, "Merhaba");
        waitAndClick(firstMobile, messagePage.sendMessageButton);

        sleep(5);
    }
}
