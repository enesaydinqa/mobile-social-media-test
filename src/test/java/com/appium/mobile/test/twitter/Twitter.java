package com.appium.mobile.test.twitter;

import com.appium.context.app.TwitterAndroidTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Twitter extends TwitterAndroidTest{
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);


    @Before
    public void init() throws Exception
    {
        super.init();


    }

    @Test
    public void login(){
        logger.info("test is running");
    }
}
