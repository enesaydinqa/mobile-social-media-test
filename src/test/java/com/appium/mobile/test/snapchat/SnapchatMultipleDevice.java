package com.appium.mobile.test.snapchat;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.SnapchatAndroidTest;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

;

public class SnapchatMultipleDevice extends SnapchatAndroidTest {
    private Logger logger = Logger.getLogger(SnapchatStoryTest.class);
    private String user_sender="testenerjim@gmail.com";
    private String user_receiver="mbcmtestuser";
    private String password_sender="enerjimE1";
    private String password_receiver="mbcm1234";
    private String name_sender="enerjim2019";
    private String name_receiver="mbcmtestuser";

    @Before
    public void init() throws Exception {
        super.init(true);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendAndControlMessageWithMultipleDevice() throws Exception {
        String text = "This is a test message: " +RandomStringUtils.randomAlphanumeric(50);
        loginSnapchat(firstMobile, user_sender, password_sender);
        loginSnapchat(secondMobile,user_receiver , password_receiver);
        goMessagePage(firstMobile,name_receiver);
        goMessagePage(secondMobile,name_sender);
        sendMessage(firstMobile,text);
        controlReceivedMessage(secondMobile,text);

    }
}
