package com.appium.mobile.test.whatsapp;

import com.annotations.Author;
import com.annotations.Contact;
import com.appium.context.app.WhatsappAndroidTest;
import com.appium.pages.whatsapp.HomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class WhatsappMultipleDeviceTest extends WhatsappAndroidTest {
    private Logger logger = Logger.
            getLogger(WhatsappMultipleDeviceTest.class);
    private String message;
    private String friend = "Atike";

    @Before
    public void init() throws Exception {
        super.init(true);
        homePage = new HomePage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendAndControlMessage() throws Exception {
        message = "This is a test message: " + RandomStringUtils.randomAlphanumeric(10);
        cleanNotification(secondMobile);
        goMessagePageWithSelectedUser(firstMobile, friend);
        sendMessage(firstMobile, message);
        controlMessage(secondMobile, message);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendAndControlImage() throws Exception {
        sleep(1);
        cleanNotification(secondMobile);
        goMessagePageWithSelectedUser(firstMobile, friend);
        takeAndSendPhoto(firstMobile);
        controlImage(secondMobile);
    }


}
