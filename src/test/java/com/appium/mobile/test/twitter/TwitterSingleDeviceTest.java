package com.appium.mobile.test.twitter;

import com.annotations.Author;
import com.annotations.Contact;
import com.appium.client.objects.TwitterReport;
import com.appium.context.app.TwitterAndroidTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Description;

public class TwitterSingleDeviceTest extends TwitterAndroidTest
{
    public Logger logger = Logger.getLogger(TwitterSingleDeviceTest.class);

    @Before
    public void init() throws Exception
    {
        super.init();
        twitterReport = new TwitterReport();

        login(firstMobile, configuration.getFirstTwitterTestUser(), configuration.getTwitterTestUserPassword());

        logOutTwitter(firstMobile);
    }

    @Test
    @Description("Send Tweet")
    @Contact(Author.ATIKE)
    public void testSentTweet() throws Exception
    {
        writeAndSentTweet(firstMobile);
    }

}