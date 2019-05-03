package com.appium.mobile.test.Messenger;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.MessengerAndroidTest;
import com.appium.mobile.test.instagram.InstagramMultipleDeviceTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MessengerMultipleDeviceTest extends MessengerAndroidTest {

    private Logger logger = Logger.getLogger(InstagramMultipleDeviceTest.class);
    @Before
    public void init() throws Exception {
        super.init();
    }

    @Test
    @Contact(Author.SELIM)
    public void testSendMessage() throws InterruptedException, IOException {

    }
}
