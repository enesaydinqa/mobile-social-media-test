package com.appium.mobile.test.twitter;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.TwitterAndroidTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import com.appium.pages.instagram.DirectMessagePage;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.ProfilePage;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.appium.context.Events.SwipeDirection.UP;

public class TwitterMultipleDeviceTest extends TwitterAndroidTest {
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);
    private HomePage homePage;
    private ProfilePage profilePage;
    @Before
    public void init() throws Exception {
        super.init(true);
        homePage = new HomePage(secondMobile);
        profilePage= new ProfilePage(secondMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendAndControlTweet() throws IOException, InterruptedException{
        logger.info("login process is started");
        sleep(10);
        //loginTwitter(firstMobile, "aktel112@gmail.com", "enerjimE1");
     //   loginTwitter(secondMobile, "testenerjim@gmail.com", "enerjimE1");
        loginTwitter(firstMobile, "testenerjim@gmail.com", "enerjimE1");
//        sleep(10);
//        swipeScreen(firstMobile,UP,2);
//        writeAndSendTweet(firstMobile);
//        waitElementVisible(firstMobile,homePage.lastTweet);
//        System.out.println(homePage.lastTweet.getAttribute("contentDescription"));
//        waitAndClick(firstMobile,homePage.threeLine,true,"three line is clicked");
//        waitAndClick(firstMobile,homePage.profile,true,"profile menu is clicked");
//        waitElementVisible(firstMobile,profilePage.lastTweet);
//        waitAndClick(firstMobile,profilePage.back,true,"back to home page button is clicked");
//        System.out.println(profilePage.lastTweet.getAttribute("contentDescription"));
//        exitFromTwitter(firstMobile);
//    waitAndClick(firstMobile, homePageOne.messageButton);
//    waitAndClick(secondMobile, homePageSecond.messageButton);
}
}
