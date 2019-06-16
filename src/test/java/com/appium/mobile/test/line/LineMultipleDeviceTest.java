package com.appium.mobile.test.line;

import com.annotations.Author;
import com.annotations.Contact;
import com.appium.context.app.LineAndroidTest;
import com.appium.pages.line.MessagePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LineMultipleDeviceTest extends LineAndroidTest
{
    private Logger logger = Logger.getLogger(LineMultipleDeviceTest.class);

    private MessagePage messagePage;

    @Before
    public void init() throws Exception
    {
        super.init(true);
        messagePage = new MessagePage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendMessage() throws Exception
    {
        String message = "This is a test message: " + RandomStringUtils.randomAlphanumeric(20);

        goMessagePage(firstMobile, configuration.getLineReceiverDisplayName());
        sendTextMessage(firstMobile, message);
        isMessageReceived(secondMobile);
        controlReceivedMessage(secondMobile, message);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendImageMessage() throws Exception
    {
        goMessagePage(firstMobile, configuration.getLineReceiverDisplayName());
        takeAndSendImage(firstMobile);
        isMobileElementDisplayedOnPage(messagePage.receivedcameraimage);
        isMessageReceived(secondMobile);
        controlReceivedMessage(secondMobile, configuration.getLineSenderDisplayName() + " sent a photo.");
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendSticker() throws Exception
    {
        goMessagePage(firstMobile, configuration.getLineReceiverDisplayName());
        sendStickers(firstMobile);
        isMessageReceived(secondMobile);
        controlReceivedMessage(secondMobile, "(" + configuration.getLineSenderDisplayName() + " sent a sticker.)");
        sleep(5);
    }

}