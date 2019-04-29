package com.appium.mobile.test.twitter;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.TwitterAndroidTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.LoginPage;
import com.appium.pages.twitter.ProfilePage;
import com.appium.utils.TwitterReportGenerate;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.context.annotation.Description;

import static com.appium.context.Events.SwipeDirection.DOWN;
import static com.appium.context.Events.SwipeDirection.UP;


public class Twitter extends TwitterAndroidTest {
    @Rule
    public TwitterReportGenerate screenShootRule = new TwitterReportGenerate();


    ExtentTest test;
    public Logger logger = Logger.getLogger(Twitter.class);
    public static String t = " ";
    private LoginPage loginPage;
    private HomePage homePage;
    private ProfilePage profilePage;

    @Before
    public void init() throws Exception {
        super.init();
        loginPage = new LoginPage(firstMobile);
        homePage = new HomePage(firstMobile);
        profilePage = new ProfilePage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    @Description("Send Tweet")
    public void sendMessageText() throws InterruptedException {
        t = "Send Tweet test is started";
        logger.info(t);
        // test.log(LogStatus.INFO,"Send Tweet test is started");
        loginTwitter(firstMobile, "aktel112@gmail.com", "enerjimE1");
        sleep(2);
        writeAndSendTweet(firstMobile);
        exitFromTwitter(firstMobile);

    }

    @Test
    @Contact(Author.ATIKE)
    @Description("Send Tweet and Control Message")
    public void controlMessageText() throws InterruptedException {
        logger.info("login process is started");
        loginTwitter(firstMobile, "aktel112@gmail.com", "enerjimE1");
        sleep(5);
        writeAndSendTweet(firstMobile);
        waitElementVisible(firstMobile, homePage.lastTweet);
        swipeScreen(firstMobile, UP, 10);
        sleep(5);

        logger.info("Control Home Panel:  " + getAttribute(homePage.lastTweet, "contentDescription"));
        waitAndClick(firstMobile, homePage.threeLine, true, "three line is clicked");
        waitAndClick(firstMobile, homePage.profile, true, "profile menu is clicked");

        waitElementVisible(firstMobile, profilePage.lastTweet);
        waitAndClick(firstMobile, profilePage.back, true, "back to home page button is clicked");
        logger.info("Control Profile Panel:  " + getAttribute(homePage.lastTweet, "contentDescription"));
        exitFromTwitter(firstMobile);


    }

}
