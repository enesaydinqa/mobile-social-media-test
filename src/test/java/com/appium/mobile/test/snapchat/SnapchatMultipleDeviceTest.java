package com.appium.mobile.test.snapchat;

import com.annotations.Author;
import com.annotations.Contact;
import com.appium.context.app.SnapchatAndroidTest;
import io.appium.java_client.MobileElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SnapchatMultipleDeviceTest extends SnapchatAndroidTest
{
    private Logger logger = Logger.getLogger(SnapchatSingleDeviceTest.class);

    @Before
    public void init() throws Exception
    {
        super.init(true);
    }

    @Test
    @Contact(Author.ATIKE)
    public void testMessageSend() throws Exception
    {
        String text = "This is a test message: " + RandomStringUtils.randomAlphanumeric(50);

        login(firstMobile, configuration.getFirstSnapChatTestUserName(), configuration.getSnapChatTestUserPassword());
        login(secondMobile, configuration.getSecondSnapChatTestUserName(), "mbcm1234");

        goMessagePage(firstMobile, configuration.getSecondSnapChatTestUserName());
        goMessagePage(secondMobile, configuration.getFirstSnapChatTestUserName());
        sendMessage(firstMobile, text, true, "Send Message");

        By expectedMessage = By.xpath("//android.widget.TextView[@text='" + text + "']");

        waitElementVisible(secondMobile, (MobileElement) secondMobile.findElement(expectedMessage), true, "Received Message");
    }
}
