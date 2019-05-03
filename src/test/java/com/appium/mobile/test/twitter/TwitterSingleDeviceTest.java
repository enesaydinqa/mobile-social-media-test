package com.appium.mobile.test.twitter;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.TwitterAndroidTest;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.ProfilePage;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Description;

import static com.appium.context.Events.SwipeDirection.UP;

public class TwitterSingleDeviceTest extends TwitterAndroidTest
{
    public Logger logger = Logger.getLogger(TwitterSingleDeviceTest.class);

    private HomePage homePage;
    private ProfilePage profilePage;

    @Before
    public void init() throws Exception
    {
        super.init();

        homePage = new HomePage(firstMobile);
        profilePage = new ProfilePage(firstMobile);

        login(firstMobile, configuration.getFirstTwitterTestUser(), configuration.getTwitterTestUserPassword());
    }

    @After
    public void teardown()
    {
        logOutFromTwitter(firstMobile);

        super.tearDown();
    }

    @Test
    @Description("Send Tweet")
    @Contact(Author.ATIKE)
    public void testSendMessageText() throws InterruptedException
    {
        writeAndSendTweet(firstMobile);
    }

    @Test
    @Description("Send Tweet and Control Message")
    @Contact(Author.ATIKE)
    public void testControlMessageText() throws InterruptedException
    {
        writeAndSendTweet(firstMobile);
        waitElementVisible(firstMobile, homePage.lastTweet);
        swipeScreen(firstMobile, UP, 10);
        sleep(5);

        logger.info("Control Home Panel:  " + getAttribute(homePage.lastTweet, "contentDescription"));
        waitAndClick(firstMobile, homePage.threeLineButton, true, "three line is clicked");
        waitAndClick(firstMobile, homePage.profile, true, "profile menu is clicked");

        waitElementVisible(firstMobile, profilePage.lastTweet);
        waitAndClick(firstMobile, profilePage.back, true, "back to home page button is clicked");
        logger.info("Control Profile Panel:  " + getAttribute(homePage.lastTweet, "contentDescription"));
        logOutFromTwitter(firstMobile);


    }

}
