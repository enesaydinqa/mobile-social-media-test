package com.appium.mobile.test.twitter;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.client.objects.TwitterReport;
import com.appium.context.app.TwitterAndroidTest;
import com.appium.utils.ReportGenerate;
import com.appium.utils.ReportInformation;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.context.annotation.Description;

public class TwitterSingleDeviceTest extends TwitterAndroidTest
{
    public Logger logger = Logger.getLogger(TwitterSingleDeviceTest.class);

    @Rule
    public ReportGenerate screenShootRule = new ReportGenerate()
    {
        @Override
        public void reportInformation(ExtentTest test)
        {
            ReportInformation.twitterReportFill(deviceInfo, twitterReport, test);
        }
    };

    @Before
    public void init() throws Exception
    {
        super.init();

        twitterReport = new TwitterReport();

        loginIn(firstMobile, configuration.getFirstTwitterTestUser(), configuration.getTwitterTestUserPassword());
    }

    @After
    public void teardown() throws Exception
    {
        logOutFromTwitter(firstMobile);

        super.tearDown();
    }

    @Test
    @Description("Send Tweet")
    @Contact(Author.ATIKE)
    public void testSentTweet() throws Exception
    {
        writeAndSentTweet(firstMobile);
    }

}