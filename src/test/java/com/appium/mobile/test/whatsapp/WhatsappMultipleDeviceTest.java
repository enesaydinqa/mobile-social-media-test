package com.appium.mobile.test.whatsapp;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.WhatsappAndroidTest;
import com.appium.pages.whatsapp.HomePage;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class WhatsappMultipleDeviceTest extends WhatsappAndroidTest {
    private Logger logger = Logger.
            getLogger(WhatsappMultipleDeviceTest.class);

    @Before
    public void init() throws Exception {
        super.init(true);//true
        homePage = new HomePage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendAndControlMessage() throws Exception {
        logger.info("test başladı");
        goMessagePageWithSelectedUser(firstMobile);
        sendMessage(firstMobile);
        goMessagePageWithSelectedUser(secondMobile);
        controlMessage(secondMobile);
    }


}
