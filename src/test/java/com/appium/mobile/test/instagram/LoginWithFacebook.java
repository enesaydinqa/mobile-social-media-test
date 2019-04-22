package com.appium.mobile.test.instagram;

import com.appium.context.app.InstagramAndroidTest;
import com.appium.pages.instagram.*;
import com.appium.utils.InstagramReportGenerate;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LoginWithFacebook extends InstagramAndroidTest {
    private Logger logger = Logger.getLogger(InstagramSingleDeviceTest.class);

    private String username;
    private String password;

    @Rule
    public InstagramReportGenerate screenShootRule = new InstagramReportGenerate();

    @Before
    public void init() throws Exception {
        super.init();
        username = configuration.configProps.getProperty("instagram.atike.test.user");
        password = configuration.configProps.getProperty("instagram.atike.test.password");
    }

    @Test
    public void loginWithFacebook() throws Exception {
        loginInstagram(firstMobile, username, password);
    }
}
