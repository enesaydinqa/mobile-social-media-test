package com.appium.mobile.test.twitter;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.TwitterAndroidTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.LoginPage;
import com.appium.pages.twitter.ProfilePage;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static com.appium.context.Events.SwipeDirection.DOWN;
import static com.appium.context.Events.SwipeDirection.UP;


public class Twitter extends TwitterAndroidTest {
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private LoginPage loginPage;
    private HomePage homePage;
    private ProfilePage profilePage;

    @Before
    public void init() throws Exception {
        super.init();
        loginPage = new LoginPage(firstMobile);
        homePage = new HomePage(firstMobile);
        profilePage= new ProfilePage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendMessageText() throws InterruptedException {
        logger.info("login process is started");
        loginTwitter(firstMobile, "aktel112@gmail.com", "enerjimE1");
        sleep(2);
        writeAndSendTweet(firstMobile);
        exitFromTwitter(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void controlMessageText() throws InterruptedException {
        logger.info("login process is started");
        loginTwitter(firstMobile, "aktel112@gmail.com", "enerjimE1");
        sleep(10);
        writeAndSendTweet(firstMobile);
        waitElementVisible(firstMobile,homePage.lastTweet);
        swipeScreen(firstMobile,UP,10);
        sleep(5);

        System.out.println(homePage.lastTweet.getAttribute("contentDescription"));
        waitAndClick(firstMobile,homePage.threeLine,true,"three line is clicked");
        waitAndClick(firstMobile,homePage.profile,true,"profile menu is clicked");

        waitElementVisible(firstMobile,profilePage.lastTweet);
        waitAndClick(firstMobile,profilePage.back,true,"back to home page button is clicked");
        System.out.println(profilePage.lastTweet.getAttribute("contentDescription"));
        exitFromTwitter(firstMobile);
    }
}
