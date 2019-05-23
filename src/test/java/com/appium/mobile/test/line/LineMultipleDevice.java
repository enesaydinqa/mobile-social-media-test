package com.appium.mobile.test.line;

import com.annotations.Author;
import com.annotations.Contact;
import com.appium.context.app.LineAndroidTest;
import com.appium.pages.line.MessagePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LineMultipleDevice extends LineAndroidTest
{
    private Logger logger = Logger.getLogger(LineMultipleDevice.class);

    public String user_receiver = "Alike Workman";
    public String user_sender = "Testnur Enerjim";

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

        goMessagePage(firstMobile, user_receiver);
        sendTextMessage(firstMobile, message);
        isMessageReceived(secondMobile);
        controlReceivedMessage(secondMobile, message);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendImageMessage() throws Exception
    {
        goMessagePage(firstMobile, user_receiver);
        takeAndSendImage(firstMobile);
        isMobileElementDisplayedOnPage(messagePage.receivedcameraimage);
        isMessageReceived(secondMobile);
        controlReceivedMessage(secondMobile, user_sender + " sent a photo.");
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendSticker() throws Exception
    {
        goMessagePage(firstMobile, user_receiver);
        sendStickers(firstMobile);
        isMessageReceived(secondMobile);
        controlReceivedMessage(secondMobile, "(" + user_sender + " sent a sticker.)");
        sleep(5);
    }

}